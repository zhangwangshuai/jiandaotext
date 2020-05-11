package com.example.feame3.home.view;

import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.feame3.R;
import com.example.feame3.base.BaseActivity;
import com.example.feame3.home.adapter.HomeFragmentAdapter;
import com.example.feame3.home.contract.HomeContract;
import com.example.feame3.home.presenter.HomePresenterImpl;
import com.example.feame3.home.view.fragment.MyFragment;
import com.example.feame3.home.view.fragment.RecommendFragment;
import com.example.feame3.home.view.fragment.TopicFragment;
import com.example.feame3.home.view.fragment.VedioFragmet;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BaseActivity<HomePresenterImpl> implements HomeContract.IHomeView {

    private ViewPager viewPager;

    private RecommendFragment recommendFragment;
    private TopicFragment topicFragment;
    private MyFragment myFragment;
    private VedioFragmet vedioFragmet;

    private List<Fragment> fragments;

    private HomeFragmentAdapter homeFragmentAdapter;
    private RadioButton recommoend_tab;
    private RadioButton vedio_tab;
    private RadioButton topic_tab;
    private RadioButton my_tab;
    private RadioGroup radioGoup;

    @Override
    public int getLayoutID() {
        return R.layout.activity_home;
    }


    @Override
    protected HomePresenterImpl initPresenter() {
        return new HomePresenterImpl();
    }

    @Override
    public void initView() {

        fragments = new ArrayList<>();

        viewPager = findViewById(R.id.fragment_vp);

        recommendFragment = new RecommendFragment();
        topicFragment = new TopicFragment();
        myFragment =new MyFragment();
        vedioFragmet = new VedioFragmet();

        fragments.add(recommendFragment);
        fragments.add(vedioFragmet);
        fragments.add(topicFragment);
        fragments.add(myFragment);

        homeFragmentAdapter = new HomeFragmentAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(homeFragmentAdapter);
        viewPager.setCurrentItem(0);//默认展示第一个
        viewPager.setOffscreenPageLimit(4);//缓存4个

        radioGoup = findViewById(R.id.tabs_rg);
        recommoend_tab = findViewById(R.id.recommoend_tab);
        vedio_tab = findViewById(R.id.vedio_tab);
        topic_tab = findViewById(R.id.topic_tab);
        my_tab = findViewById(R.id.my_tab);

    }

    @Override
    public void initData() {
        mPresenter.getBannerView();

//        mPresenter.getHomeTabList();

    }

    @Override
    public void initLinstener() {
        radioGoup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.recommoend_tab:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.vedio_tab:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.my_tab:
                        viewPager.setCurrentItem(3);
                        break;
                    case R.id.topic_tab:
                        viewPager.setCurrentItem(2);
                        break;
                }
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        recommoend_tab.setChecked(true);
                        break;
                    case 1:
                        vedio_tab.setChecked(true);
                        break;
                    case 2:
                        topic_tab.setChecked(true);
                        break;
                    case 3:
                        my_tab.setChecked(true);
                        break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }


    @Override
    public void setBannView(String string) {
//        得到bannview的数据了
    }

    @Override
    public void setTabList(String string) {
//        最终获得Tab栏数据
    }
}
