package com.example.feame3.login.model;

import android.util.Log;

import com.example.feame3.login.contract.AffirmContart;
import com.example.feame3.net.INetCallBack;
import com.example.feame3.net.NetWorkFactory;
import com.example.feame3.net.ParamsUtils;
import com.example.feame3.net.api.URLConstants;

import java.util.HashMap;

public class AffirmRegisterModel implements AffirmContart.IAffirmMode {
    @Override
    public <T> void register(String phoneNum, String password, String affirm_password, INetCallBack<T> iNetCallBack) {
        HashMap<String, String> commonParams = ParamsUtils.getCommonParams();
        commonParams.put("mobile",phoneNum);
        commonParams.put("password",password);
        commonParams.put("affirm_password",affirm_password);
        for (String Key: commonParams.keySet()){
            Log.e("TAG","key="+Key+",values="+commonParams.get(Key));
        }
        NetWorkFactory.getInstance().getNetWork().post(URLConstants.USERREGISTER,commonParams,iNetCallBack);

    }
}
