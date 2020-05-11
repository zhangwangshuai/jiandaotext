package com.example.feame3.home.presenter;
import com.example.feame3.net.INetCallBack;
import com.example.feame3.base.BasePresenter;
import com.example.feame3.home.bean.User;
import com.example.feame3.home.contract.HomeContract;
import com.example.feame3.home.model.HomeModelImpl;
import com.example.feame3.home.view.HomeActivity;

public class HomePresenterImpl extends BasePresenter<HomeActivity> implements HomeContract.IHomePresenter {

    private HomeContract.IHomeMode  iHomeMode;
//    private HomeContract.IHomeView iHomeView;

    public HomePresenterImpl() {
        iHomeMode = new HomeModelImpl(this);
    }
    @Override
    public void callHomeBannview(String string) {
//        P层中拿到数据
        mview.setBannView(string);
    }
    @Override
    public void getBannerView() {
        iHomeMode.getHomeBannview(new INetCallBack<User>() {
            @Override
            public void onSuccess(User user) {

            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }

    @Override
    public void getHomeTabList() {

    }
}
