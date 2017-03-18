package com.gdufs.planter.common;

/**
 * Created by peng on 2017/3/18.
 */

public interface BaseView {
    void onResponseSuccess(DataResponse response);
    void onResponseFailure(Exception e);
}
