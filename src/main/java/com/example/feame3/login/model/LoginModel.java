package com.example.feame3.login.model;

import android.util.Log;

import com.example.feame3.login.contract.LoginContract;
import com.example.feame3.net.INetCallBack;
import com.example.feame3.net.NetWorkFactory;
import com.example.feame3.net.ParamsUtils;
import com.example.feame3.net.api.URLConstants;

import java.util.HashMap;

public class LoginModel implements LoginContract.ILoginMode {
    @Override
    public <T> void getVerified(String phonemub, String type, INetCallBack<T> iNetCallBack) {
        HashMap<String, String> commonParams = ParamsUtils.getCommonParams();
        commonParams.put("mobile",phonemub);
        commonParams.put("type",type);
        for (String Key: commonParams.keySet()){
            Log.e("TAG","key="+Key+",values="+commonParams.get(Key));
        }
        NetWorkFactory.getInstance().getNetWork().post(URLConstants.SENDVERIFED,commonParams,iNetCallBack);
    }

    @Override
    public <T> void getLogin(String phoneNum, String smsCode, INetCallBack<T> iNetCallBack) {
        HashMap<String, String> commonParams = ParamsUtils.getCommonParams();
        commonParams.put("mobile",phoneNum);
        commonParams.put("sms_code",smsCode);
        for (String Key: commonParams.keySet()){
            Log.e("TAG","key="+Key+",values="+commonParams.get(Key));
        }
        NetWorkFactory.getInstance().getNetWork().post(URLConstants.LOGIN,commonParams,iNetCallBack);

    }

    @Override
    public <T> void checkSmsCode(String phoneNum, String smsCode, String type, INetCallBack<T> iNetCallBack) {
        HashMap<String, String> commonParams = ParamsUtils.getCommonParams();
        commonParams.put("mobile",phoneNum);
        commonParams.put("type",type);
        commonParams.put("sms_code",smsCode);
        for (String Key: commonParams.keySet()){
            Log.e("TAG","key="+Key+",values="+commonParams.get(Key));
        }
        NetWorkFactory.getInstance().getNetWork().post(URLConstants.CHECKMSCODE,commonParams,iNetCallBack);

    }
}
