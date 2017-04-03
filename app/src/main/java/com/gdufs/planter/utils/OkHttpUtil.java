package com.gdufs.planter.utils;

import android.os.Handler;
import android.os.Looper;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;



import java.io.IOException;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.Map;
import java.util.concurrent.TimeUnit;


/**
 * Created by peng on 2017/3/15.
 */

public class OkHttpUtil {

    private static OkHttpUtil mInstance;
    private OkHttpClient mOkHttpClient;
    private Handler mDelivery;

    private OkHttpUtil() {
        mOkHttpClient = new OkHttpClient();
        mOkHttpClient.setConnectTimeout(10, TimeUnit.SECONDS);
        mOkHttpClient.setWriteTimeout(10, TimeUnit.SECONDS);
        mOkHttpClient.setReadTimeout(30, TimeUnit.SECONDS);
        //cookie enabled
        mOkHttpClient.setCookieHandler(new CookieManager(null, CookiePolicy.ACCEPT_ORIGINAL_SERVER));
        mDelivery = new Handler(Looper.getMainLooper());
    }

    private synchronized static OkHttpUtil getmInstance() {
        if (mInstance == null) {
            synchronized (OkHttpUtil.class) {
                if (mInstance == null) {
                    mInstance = new OkHttpUtil();
                }
            }
        }
        return mInstance;
    }

    private void getRequest(String url, final ResultCallback callback) {
        final Request request = new Request.Builder().url(url).build();
        deliveryResult(callback, request);
    }

    private void postRequest(String url, final ResultCallback callback, Map<String, Object> params) {
        Request request = buildPostRequest(url, params);
        deliveryResult(callback, request);
    }

    private void deliveryResult(final ResultCallback callback, Request request) {
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, final IOException e) {
                sendFailCallback(callback, e);
            }
            @Override
            public void onResponse(Response response) throws IOException {
                try {
                    String str = response.body().string();
                    sendSuccessCallBack(callback, str);
                } catch (final Exception e) {
                    sendFailCallback(callback, e);
                }
            }
        });
    }

    private void sendFailCallback(final ResultCallback callback, final Exception e) {
        mDelivery.post(new Runnable() {
            @Override
            public void run() {
                if (callback != null) {
                    callback.onFailure(e);
                }
            }
        });
    }

    private void sendSuccessCallBack(final ResultCallback callback, final String obj) {

        mDelivery.post(new Runnable() {
            @Override
            public void run() {
                if (callback != null) {
                    callback.onSuccess(obj);
                }
            }
        });
    }

    private Request buildPostRequest(String url, Map<String, Object> params) {
        String jsonData = JsonUtil.serialize(params);
        final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, jsonData);
        return new Request.Builder().url(url).post(body).build();
    }


    /**********************对外接口************************/

    /**
     * get请求
     *
     * @param url      请求url
     * @param callback 请求回调
     */
    public static void get(String url, ResultCallback callback) {
        getmInstance().getRequest(url, callback);
    }

    /**
     * post请求
     *
     * @param url      请求url
     * @param callback 请求回调
     * @param params   请求参数
     */
    public static void post(String url, final ResultCallback callback, Map<String, Object> params) {
        getmInstance().postRequest(url, callback, params);

    }
//
//    /**
//     * http请求回调类,回调方法在UI线程中执行
//     *
//     * @param <T>
//     */
//    public static abstract class ResultCallback<T> {
//
//        /**
//         * 请求成功回调
//         *
//         * @param response
//         */
//        public abstract void onSuccess(T response);
//
//        /**
//         * 请求失败回调
//         *
//         * @param e
//         */
//        public abstract void onFailure(Exception e);
//    }


}
