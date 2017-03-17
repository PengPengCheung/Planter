package com.gdufs.planter.utils;

/**
 * Created by peng on 2017/3/15.
 */

/**
 * http请求回调类,回调方法在UI线程中执行
 *
 * @param <T>
 */
public interface ResultCallback<T> {

    /**
     * 请求成功回调
     *
     * @param response
     */
    void onSuccess(T response);

    /**
     * 请求失败回调
     *
     * @param e
     */
    void onFailure(Exception e);
}
