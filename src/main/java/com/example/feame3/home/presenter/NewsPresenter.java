package com.example.feame3.home.presenter;

import com.example.feame3.base.BasePresenter;
import com.example.feame3.home.bean.NewsBean;
import com.example.feame3.home.contract.NewsFragmentContract;
import com.example.feame3.home.contract.RecommendContract;
import com.example.feame3.home.model.NewsModel;
import com.example.feame3.net.INetCallBack;
public class NewsPresenter extends BasePresenter<NewsFragmentContract.INewsView> implements RecommendContract.IRecommendPresenter {
    private NewsFragmentContract.INewsMode iNewsMode;

    @Override
    public void getColumList() {

    }

    public NewsPresenter() {

        iNewsMode = new NewsModel();

    }

    @Override
    public void getRecommendList(String id) {
        iNewsMode.getRecommendList(id,new INetCallBack<NewsBean>() {
            @Override
            public void onSuccess(NewsBean newsBean) {

                mview.setRecommendList(newsBean);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });


    }
}
