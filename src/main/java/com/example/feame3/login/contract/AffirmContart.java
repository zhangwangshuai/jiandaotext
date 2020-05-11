package com.example.feame3.login.contract;

import com.example.feame3.base.BaseView;
import com.example.feame3.login.bean.AffirmRegisterBean;
import com.example.feame3.login.bean.VerfiedBean;
import com.example.feame3.net.INetCallBack;

public class AffirmContart {
    //    V层接口
    public interface IAffirmView extends BaseView {
        void registerResult(AffirmRegisterBean affirmRegisterBean);
    }

    //    model层接口
    public interface IAffirmMode {
        <T> void register(String phoneNum,String password,String affirm_password,INetCallBack<T> iNetCallBack);
    }

    //    p层接口
    public interface IAffirmPresenter {
        void register(String phoneNum,String password,String affirm_password);
    }
}
