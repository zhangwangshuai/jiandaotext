package com.example.feame3.home.contract;

import com.example.feame3.base.BaseView;
import com.example.feame3.home.bean.NewsBean;
import com.example.feame3.net.INetCallBack;

public class NewsFragmentContract {


    public interface INewsView extends BaseView {
        void  setRecommendList(NewsBean newsBean);
    }
    public interface INewsMode{
        <T> void getRecommendList(String tabID, INetCallBack<T> iNetCallBack);
    }
    public interface INewsPresenter{
        void getRecommend(String string);
    }
}