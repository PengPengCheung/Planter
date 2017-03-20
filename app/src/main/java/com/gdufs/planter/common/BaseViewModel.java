package com.gdufs.planter.common;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by peng on 2017/3/19.
 */

public class BaseViewModel implements Serializable{

    @SerializedName(Resource.KEY.KEY_COURSE_ID)
    private String mCourseId;

    @SerializedName(Resource.KEY.KEY_MODULE_ID)
    private int mModuleId;

    @SerializedName(Resource.KEY.KEY_ACTION_ID)
    private int mActionId;

    public String getmCourseId() {
        return mCourseId;
    }

    public void setmCourseId(String mCourseId) {
        this.mCourseId = mCourseId;
    }

    public int getmModuleId() {
        return mModuleId;
    }

    public void setmModuleId(int mModuleId) {
        this.mModuleId = mModuleId;
    }

    public int getmActionId() {
        return mActionId;
    }

    public void setmActionId(int mActionId) {
        this.mActionId = mActionId;
    }
}
