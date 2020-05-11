package com.example.feame3.home.adapter;
import android.util.Log;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.feame3.R;
import com.example.feame3.home.bean.NewsBean;
import com.example.feame3.home.view.Banner_Indicator;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class NesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private String tabID;//当前列表属于
    //上下文。bean对象
    private Context context;
    private NewsBean newsBean;
    private int TYPE_BANNER_ONE = 0;//banner
    private int TYPE_MARQUEE_TWO = 1;//跑马灯
    private int TYPE_SMLLIMAGE_THREE = 2;//小图
    private int TYPE_BIGIMAGE_FOUR = 3;// 大图
    private int TYPE_BIGVIDEO_FIVE = 4;// 视频
    private Timer timer;
    private TimerTask timerTask;
    private ViewHolderOne viewHolderOne;
    //函数
    public NesAdapter(Context context, NewsBean newsBean) {
        this.context = context;
        this.newsBean = newsBean;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_BANNER_ONE) {
            View bannerView = LayoutInflater.from(parent.getContext()).inflate(R.layout.banner_one, parent, false);
            return new ViewHolderOne(bannerView);
        } else if (viewType == TYPE_MARQUEE_TWO) {
            View marqueeView = LayoutInflater.from(parent.getContext()).inflate(R.layout.banner_two, parent, false);
            return new ViewHolderTwo(marqueeView);
        } else if (viewType == TYPE_SMLLIMAGE_THREE) {
            View smllimageView = LayoutInflater.from(parent.getContext()).inflate(R.layout.smllimage_three, parent, false);
            return new ViewHolderOneThree(smllimageView);
        } else if (viewType == TYPE_BIGIMAGE_FOUR) {
            View bigimageView = LayoutInflater.from(parent.getContext()).inflate(R.layout.bigimage_four, parent, false);
            return new ViewHolderOneFour(bigimageView);
        } else if (viewType == TYPE_BIGVIDEO_FIVE) {
            View bigvideoView = LayoutInflater.from(parent.getContext()).inflate(R.layout.bigvideo_five, parent, false);
            return new ViewHolderFive(bigvideoView);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        NewsBean.DataBean.ArticleListBean articleListBean = newsBean.getData().getArticle_list().get(position);

        int itemViewType = getItemViewType(position);
        if (itemViewType == TYPE_BANNER_ONE) {
            ViewHolderOne viewHolderOne = (ViewHolderOne) holder;
            this.viewHolderOne=viewHolderOne;
            initBanner(newsBean, viewHolderOne);
        }
        if (itemViewType == TYPE_MARQUEE_TWO) {
            ViewHolderTwo viewHolderTwo = (ViewHolderTwo) holder;
            List<NewsBean.DataBean.FlashListBean> flash_list = newsBean.getData().getFlash_list();
            viewHolderTwo.textView.setText(flash_list.get(position).getTheme());
        } else if (itemViewType == TYPE_SMLLIMAGE_THREE) {
            ViewHolderOneThree viewHolderOneThree = (ViewHolderOneThree) holder;
            Glide.with(context).load(articleListBean.getImage_url()).into(viewHolderOneThree.small_image);
            viewHolderOneThree.smll_image_title.setText(articleListBean.getTheme());
            viewHolderOneThree.smll_image_type.setText(articleListBean.getColumn_name());
        } else if (itemViewType == TYPE_BIGIMAGE_FOUR) {
            ViewHolderOneFour viewHolderOneFour = (ViewHolderOneFour) holder;
            Glide.with(context).load(articleListBean.getImage_url()).into(viewHolderOneFour.big_image);
            viewHolderOneFour.big_image_title.setText(articleListBean.getTheme());
            viewHolderOneFour.big_image_type.setText(articleListBean.getColumn_name());
        } else if (itemViewType == TYPE_BIGVIDEO_FIVE) {
            ViewHolderFive viewHolderFive = (ViewHolderFive) holder;
//            viewHolderFive.setUp("视频/MP3地址","视频/MP3标题");
//            Glide.with(context).load(videoBean.getImage_url()).into(viewHolderVideo.video.ivThumb);
            viewHolderFive.jzvdStd.setUp(articleListBean.getTheme(), articleListBean.getEdit_time());
//            viewHolderFive.jzvdStd.positionInList = position;
            Glide.with(context).load(articleListBean.getImage_url()).into(viewHolderFive.jzvdStd.ivThumb);
        }
    }

    @Override
    public int getItemCount() {
        return (null != newsBean.getData().getFlash_list() &&
                newsBean.getData().getFlash_list().size() > 0) ?
                newsBean.getData().getArticle_list().size() + 2 :
                newsBean.getData().getArticle_list().size() + 1;
    }

    @Override
    public int getItemViewType(int position) {

        if (position == 0) {
            return TYPE_BANNER_ONE;
        }
        if (null != newsBean.getData().getFlash_list() && newsBean.getData().getFlash_list().size() > 0 && position == 1) {
            return TYPE_MARQUEE_TWO;
        }
        if (newsBean.getData().getArticle_list().get(position).getView_type() == 4) {
            return TYPE_BIGVIDEO_FIVE;
        } else if (newsBean.getData().getArticle_list().get(position).getView_type() == 2) {
            return TYPE_BIGIMAGE_FOUR;
        } else {
            return TYPE_SMLLIMAGE_THREE;
        }

    }

    //banner
    private class ViewHolderOne extends RecyclerView.ViewHolder {
        private ViewPager banner_viewPager;
        private Banner_Indicator banner_indicator;

        public ViewHolderOne(View bannerView) {
            super(bannerView);
            banner_viewPager = bannerView.findViewById(R.id.banner_viewpage);
            banner_indicator = bannerView.findViewById(R.id.banner_indicator);
        }
    }

    //跑马灯
    private class ViewHolderTwo extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolderTwo(View marqueeView) {
            super(marqueeView);
            textView = marqueeView.findViewById(R.id.paoMaDeng);
        }
    }
//小图

    private class ViewHolderOneThree extends RecyclerView.ViewHolder {
        private ImageView small_image;
        private TextView smll_image_title;
        private TextView smll_image_type;

        public ViewHolderOneThree(View smllimageView) {
            super(smllimageView);
            small_image = smllimageView.findViewById(R.id.small_image);
            smll_image_title = smllimageView.findViewById(R.id.smll_image_title);
            smll_image_type = smllimageView.findViewById(R.id.small_image_type);
        }
    }

    // 大图
    private class ViewHolderOneFour extends RecyclerView.ViewHolder {
        private ImageView big_image;
        private TextView big_image_title;
        private TextView big_image_type;

        public ViewHolderOneFour(View bigimageView) {
            super(bigimageView);
            big_image = bigimageView.findViewById(R.id.big_image);
            big_image_title = bigimageView.findViewById(R.id.big_image_title);
            big_image_type = bigimageView.findViewById(R.id.big_image_title);
        }
    }

    // 视频
    private class ViewHolderFive extends RecyclerView.ViewHolder {
        private JCVideoPlayer jzvdStd;
        private TextView video_title;
        private TextView video_type;

        public ViewHolderFive(View bigvideoView) {
            super(bigvideoView);
            jzvdStd = itemView.findViewById(R.id.big_video_player);
            video_title = itemView.findViewById(R.id.big_video_title);
            video_type = itemView.findViewById(R.id.big_video_type);
        }
    }


    private int viewpage_Current_Pos = 0;
    int current_banner_item;
    private List<View> banner_views = new ArrayList<>();

    private void initBanner(final NewsBean newsBean, final ViewHolderOne holder) {
        for (int i = 0; i < newsBean.getData().getBanner_list().size(); i++) {
            current_banner_item = i;
            View ban_view = LayoutInflater.from(context).inflate(R.layout.news_banner_item, null, false);
            ImageView bannerImage = ban_view.findViewById(R.id.benner_image);
            TextView bannerContent = ban_view.findViewById(R.id.banner_content);
            bannerContent.setText(newsBean.getData().getBanner_list().get(i).getDescription());
            Glide.with(context).load(newsBean.getData().getBanner_list().get(i).getImage_url()).into(bannerImage);
            banner_views.add(ban_view);
//            ban_view.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(getContext(), "点击了"+current_banner_item+"个view", Toast.LENGTH_SHORT).show();
//                }
//            });
        }
        ;

        NewsBannerAdapter bannerAdapter = new NewsBannerAdapter(banner_views);
        holder.banner_viewPager.setAdapter(bannerAdapter);

//        设置图片数量，总数
        holder.banner_indicator.setBannerImageSize(newsBean.getData().getBanner_list().size());
//        设置当前轮播图位置，默认0
        holder.banner_indicator.setCurrentBannerItem(0);

//        viewPage监听
        holder.banner_viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                current_banner_item = position;
//                在监听过程中，更改指示器种轮播图得当前位置，重绘指示器
                holder.banner_indicator.setCurrentBannerItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
//
        initTimer();
    }

    private void initTimer() {
//        倒计时
        timer = new Timer();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                viewpage_Current_Pos += 1;
                Log.e("TAG", "当前位置" + viewpage_Current_Pos % (newsBean.getData().getBanner_list().size()));
//                context.runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        viewHolderOne.banner_viewPager.setCurrentItem(viewpage_Current_Pos%(newsBean.getData().getBanner_list().size()));
//                    }
//                });
            }
        };
        timer.schedule(timerTask,  2000, 2000);
    }

    public void isCurrentVisibleToUser(boolean isVisibleToUser) {
        if(isVisibleToUser){
//            timer.schedule(timerTask, 2000, 2000);
            initTimer();
        }else{

            timer.cancel();
        }
    }
}
