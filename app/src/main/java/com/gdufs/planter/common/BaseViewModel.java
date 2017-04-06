package com.gdufs.planter.common;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by peng on 2017/3/19.
 */

public class BaseViewModel implements Serializable{

//    static final long serialVersionUID =-3334164866412534105L;
    static final long serialVersionUID =5505771155016726606L;

    @SerializedName(Resource.KEY.KEY_DATA_GET_METHOD)
    public int mDataFrom;

    @SerializedName(Resource.KEY.KEY_COURSE_ID)
    public String mCourseId;

    @SerializedName(Resource.KEY.KEY_MODULE_ID)
    public int mModuleId;

    @SerializedName(Resource.KEY.KEY_ACTION_ID)
    public int mActionId;

    @SerializedName(Resource.KEY.KEY_TEACHER_ID)
    public String mTeacherId;

    @SerializedName(Resource.KEY.KEY_STUDENT_ID)
    public String mStudentId;

    public int getmDataFrom() {
        return mDataFrom;
    }

    public void setmDataFrom(int mDataFrom) {
        this.mDataFrom = mDataFrom;
    }

    public String getmTeacherId() {
        return mTeacherId;
    }

    public void setmTeacherId(String mTeacherId) {
        this.mTeacherId = mTeacherId;
    }

    public String getmStudentId() {
        return mStudentId;
    }

    public void setmStudentId(String mStudentId) {
        this.mStudentId = mStudentId;
    }

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
