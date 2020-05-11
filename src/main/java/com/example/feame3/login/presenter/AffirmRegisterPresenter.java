package com.example.feame3.login.presenter;

import com.example.feame3.base.BasePresenter;
import com.example.feame3.login.bean.AffirmRegisterBean;
import com.example.feame3.login.contract.AffirmContart;
import com.example.feame3.login.model.AffirmRegisterModel;
import com.example.feame3.net.INetCallBack;

public class AffirmRegisterPresenter extends BasePresenter<AffirmContart.IAffirmView> implements AffirmContart.IAffirmPresenter{
    private AffirmContart.IAffirmMode iAffirmMode;

    public AffirmRegisterPresenter() {
        iAffirmMode = new AffirmRegisterModel();
    }

    @Override
    public void register(String phoneNum, String password, String affirm_password) {
        iAffirmMode.register(phoneNum, password, affirm_password, new INetCallBack<AffirmRegisterBean>() {
            @Override
            public void onSuccess(AffirmRegisterBean affirmRegisterBean) {
                mview.registerResult(affirmRegisterBean);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }
}
