package com.gdufs.planter.module.frame.model;

import com.bigkoo.pickerview.model.IPickerViewData;
import com.gdufs.planter.common.Resource;
import com.google.gson.annotations.SerializedName;

/**
 * Created by peng on 2017/4/8.
 */

public class CourseInfoModel implements IPickerViewData{

    @SerializedName(Resource.KEY.KEY_COURSE_ID)
    private String mCourseId;

    @SerializedName(Resource.KEY.KEY_COURSE_NAME)
    private String mCourseName;

    public String getmCourseId() {
        return mCourseId;
    }

    public void setmCourseId(String mCourseId) {
        this.mCourseId = mCourseId;
    }

    public String getmCourseName() {
        return mCourseName;
    }

    public void setmCourseName(String mCourseName) {
        this.mCourseName = mCourseName;
    }

    @Override
    public String getPickerViewText() {
        return mCourseName;
    }
}
