package com.example.feame3.login.contract;

import com.example.feame3.base.BaseView;
import com.example.feame3.login.bean.AffirmRegisterBean;
import com.example.feame3.login.bean.VerfiedBean;
import com.example.feame3.net.INetCallBack;

//契约类
public class LoginContract {
    //    V层接口
    public interface ILoginView extends BaseView {
        void getVeridied(VerfiedBean s);

        void getLoginResylt(AffirmRegisterBean affirmRegisterBean);
        void checkSmsCodeResult(VerfiedBean verfiedBean);
    }

    //    model层接口
    public interface ILoginMode {
        <T> void getVerified(String phonemub, String type, INetCallBack<T> iNetCallBack);
        <T> void getLogin(String phoneNum,String smsCode,INetCallBack<T> iNetCallBack);
        <T> void checkSmsCode(String phoneNum,String smsCode,String type,INetCallBack<T> iNetCallBack);
    }

    //    p层接口
    public interface ILoginPresenter {
        void getVerifend(String string, String type);
        void checkSmsCode(String phoneNum,String smsCode,String type);
        void login(String phoneNum,String smsCode);
    }
}
