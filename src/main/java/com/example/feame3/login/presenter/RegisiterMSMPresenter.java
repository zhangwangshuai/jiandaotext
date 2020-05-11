package com.example.feame3.login.presenter;

import com.example.feame3.base.BasePresenter;
import com.example.feame3.home.contract.RecommendContract;
import com.example.feame3.login.bean.VerfiedBean;
import com.example.feame3.login.contract.RegisterMSMContract;
import com.example.feame3.login.model.RegisiterMSMModel;
import com.example.feame3.net.INetCallBack;

public class RegisiterMSMPresenter extends BasePresenter<RegisterMSMContract.IRegisterMSMView> implements RegisterMSMContract.IRegisterMSMPresenter {
    private RegisterMSMContract.IRegisterMSMMode iRegisterMSMMode;

    public RegisiterMSMPresenter() {
        iRegisterMSMMode = new RegisiterMSMModel();
    }


    @Override
    public void getVerifend(String string, String type) {
        iRegisterMSMMode.getVerified(string, type, new INetCallBack<VerfiedBean>() {
            @Override
            public void onSuccess(VerfiedBean verfiedBean) {
                mview.getVeridied(verfiedBean);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }

    @Override
    public void checkSmsCode(String phoneNum, String smsCode, String type) {
        iRegisterMSMMode.checkSmsCode(phoneNum, smsCode, type, new INetCallBack<VerfiedBean>() {
            @Override
            public void onSuccess(VerfiedBean verfiedBean) {
                mview.checkSmsCodeResult(verfiedBean);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }
}
