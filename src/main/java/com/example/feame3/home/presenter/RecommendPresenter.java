package com.example.feame3.home.presenter;

import com.example.feame3.base.BasePresenter;
import com.example.feame3.home.bean.ColunmBean;
import com.example.feame3.home.bean.NewsBean;
import com.example.feame3.home.contract.RecommendContract;
import com.example.feame3.home.model.RecommendModel;
import com.example.feame3.net.INetCallBack;
public class RecommendPresenter extends BasePresenter<RecommendContract.IRecommendView> implements RecommendContract.IRecommendPresenter {


    RecommendContract.IRecommendMode iRecommendMode;

    public RecommendPresenter() {
        iRecommendMode = new RecommendModel();
    }

    @Override
    public void getColumList() {

        iRecommendMode.getColumList(new INetCallBack<ColunmBean>() {
            @Override
            public void onSuccess(ColunmBean remBean) {
                mview.setColumList(remBean);

            }

            @Override
            public void onError(Throwable throwable) {

            }
        });

    }

    @Override
    public void getRecommendList(String id) {

        iRecommendMode.getRecommendList(id,new INetCallBack<NewsBean>() {
            @Override
            public void onSuccess(NewsBean remBean) {

                mview.setRecommendList(remBean);

            }

            @Override
            public void onError(Throwable throwable) {

            }
        });

    }
}