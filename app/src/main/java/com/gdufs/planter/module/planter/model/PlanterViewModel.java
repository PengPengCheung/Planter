package com.gdufs.planter.module.planter.model;

import com.gdufs.planter.common.BaseViewModel;
import com.gdufs.planter.common.Resource;
import com.google.gson.annotations.SerializedName;

/**
 * Created by peng on 2017/3/24.
 */
public class PlanterViewModel extends BaseViewModel {

    @SerializedName(Resource.KEY.KEY_PLANTER_STATUS)
    private int mPlanterStatus;

    @SerializedName(Resource.KEY.KEY_COURSE_NAME)
    private String mCourseName;

    @SerializedName(Resource.KEY.KEY_COURSE_TIME)
    private String mCourseTime;

    @SerializedName(Resource.KEY.KEY_PLANTER_HAD_SUNSHINE)
    private int mPlanterSunshine;

    @SerializedName(Resource.KEY.KEY_PLANTER_HAD_WATER)
    private int mPlanterWater;

    @SerializedName(Resource.KEY.KEY_PLANTER_HAD_SOIL)
    private int mPlanterSoil;

    @SerializedName(Resource.KEY.KEY_PLANTER_PERCENTAGE)
    private int mPlanterPercent;

    public int getmPlanterStatus() {
        return mPlanterStatus;
    }

    public void setmPlanterStatus(int mPlanterStatus) {
        this.mPlanterStatus = mPlanterStatus;
    }

    public String getmCourseName() {
        return mCourseName;
    }

    public void setmCourseName(String mCourseName) {
        this.mCourseName = mCourseName;
    }

    public String getmCourseTime() {
        return mCourseTime;
    }

    public void setmCourseTime(String mCourseTime) {
        this.mCourseTime = mCourseTime;
    }

    public int getmPlanterSunshine() {
        return mPlanterSunshine;
    }

    public void setmPlanterSunshine(int mPlanterSunshine) {
        this.mPlanterSunshine = mPlanterSunshine;
    }

    public int getmPlanterWater() {
        return mPlanterWater;
    }

    public void setmPlanterWater(int mPlanterWater) {
        this.mPlanterWater = mPlanterWater;
    }

    public int getmPlanterSoil() {
        return mPlanterSoil;
    }

    public void setmPlanterSoil(int mPlanterSoil) {
        this.mPlanterSoil = mPlanterSoil;
    }

    public int getmPlanterPercent() {
        return mPlanterPercent;
    }

    public void setmPlanterPercent(int mPlanterPercent) {
        this.mPlanterPercent = mPlanterPercent;
    }
}
