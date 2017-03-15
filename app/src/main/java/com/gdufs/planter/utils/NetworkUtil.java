package com.gdufs.planter.utils;

import java.util.Map;

/**
 * Created by peng on 2017/3/15.
 */

public class NetworkUtil {

    private static OkHttpUtil.ResultCallback mCallback;

    public static void setResultCallback(OkHttpUtil.ResultCallback callback){
        mCallback = callback;
    }

    public static void get(String url){
        OkHttpUtil.get(url, mCallback);
    }

    public static void post(String url, Map<String, Object> params){
        OkHttpUtil.post(url, mCallback, params);
    }

}
