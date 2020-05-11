package com.example.feame3.home.model;
import com.example.feame3.net.INetCallBack;
import com.example.feame3.base.BaseModel;
import com.example.feame3.home.contract.HomeContract;

public class HomeModelImpl extends BaseModel implements HomeContract.IHomeMode {

    private HomeContract.IHomePresenter iHomePresenter;

    public HomeModelImpl(HomeContract.IHomePresenter iHomePresenter) {
        this.iHomePresenter = iHomePresenter;
    }

    @Override
    public <T> void getHomeBannview(INetCallBack<T> netCallBack) {
    }

    @Override
    public <T> void getHomeTabList(INetCallBack<T> iNetCallBack) {
    }
}