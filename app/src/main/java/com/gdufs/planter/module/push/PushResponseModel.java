package com.gdufs.planter.module.push;

import com.gdufs.planter.common.DataResponse;
import com.gdufs.planter.common.Resource;
import com.google.gson.annotations.SerializedName;

/**
 * Created by peng on 2017/4/3.
 */

public class PushResponseModel<T> {

    @SerializedName(Resource.KEY.KEY_MODULE_ID)
    private int mModuleId;

    private T data;

    public int getmModuleId() {
        return mModuleId;
    }

    public void setmModuleId(int mModuleId) {
        this.mModuleId = mModuleId;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
