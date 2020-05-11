package com.example.feame3.net;

import java.util.HashMap;

public class HttpUrlconnectionUtils implements INetWork{

    private static  HttpUrlconnectionUtils httpUrlConnetionUtils;

    private HttpUrlconnectionUtils() {
    }

    public static HttpUrlconnectionUtils getInstance() {
        if(httpUrlConnetionUtils == null){
            synchronized (RetrofitUtils.class){
                if (httpUrlConnetionUtils == null){
                    httpUrlConnetionUtils = new HttpUrlconnectionUtils();
                }
            }
        }
        return httpUrlConnetionUtils;
    }

    @Override
    public <T> void get(String url,INetCallBack<T> netCallBack) {
//        也做网络请求
//将请求到的结果通过咱们的   INetCallBack   返回的
    }

    @Override
    public <T> void get(String url, HashMap<String, String> s, INetCallBack<T> netCallBack) {

    }

    @Override
    public <T> void post(String url,INetCallBack<T> netCallBack) {

    }

    @Override
    public <T> void post(String url, HashMap<String, String> s,INetCallBack<T> netCallBack) {

    }
}

