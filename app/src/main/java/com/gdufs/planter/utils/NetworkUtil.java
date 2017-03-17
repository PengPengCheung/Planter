package com.gdufs.planter.utils;

import java.util.Map;

/**
 * Created by peng on 2017/3/15.
 */

public class NetworkUtil {

    public static void get(String url, ResultCallback callback){
        OkHttpUtil.get(url, callback);
    }

    public static void post(String url, Map<String, Object> params, ResultCallback callback){
        OkHttpUtil.post(url, callback, params);
    }

}
