package com.example.feame3.net;

import java.util.HashMap;

import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface INetWork {
//    get
//    post

    <T> void get(String url, INetCallBack<T> netCallBack);

    <T> void get(String url, HashMap<String, String> s, INetCallBack<T> netCallBack);

    <T> void post(String url, INetCallBack<T> netCallBack);


    <T> void post(String url, HashMap<String, String> s, INetCallBack<T> netCallBack);
}
