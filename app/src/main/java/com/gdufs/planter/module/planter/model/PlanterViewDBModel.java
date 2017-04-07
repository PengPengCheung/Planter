package com.gdufs.planter.module.planter.model;

import com.gdufs.planter.common.BaseViewDBModel;
import com.gdufs.planter.common.Resource;
import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by peng on 2017/3/24.
 */

@Entity
public class PlanterViewDBModel extends BaseViewDBModel {

    @Id
    private Long id;

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

    @Generated(hash = 698757901)
    public PlanterViewDBModel(Long id, int mDataFrom, String mCourseId,
            int mModuleId, int mActionId, String mTeacherId, String mStudentId,
            int mPlanterStatus, String mCourseName, String mCourseTime,
            int mPlanterSunshine, int mPlanterWater, int mPlanterSoil,
            int mPlanterPercent) {
        this.id = id;
        this.mDataFrom = mDataFrom;
        this.mCourseId = mCourseId;
        this.mModuleId = mModuleId;
        this.mActionId = mActionId;
        this.mTeacherId = mTeacherId;
        this.mStudentId = mStudentId;
        this.mPlanterStatus = mPlanterStatus;
        this.mCourseName = mCourseName;
        this.mCourseTime = mCourseTime;
        this.mPlanterSunshine = mPlanterSunshine;
        this.mPlanterWater = mPlanterWater;
        this.mPlanterSoil = mPlanterSoil;
        this.mPlanterPercent = mPlanterPercent;
    }

    @Generated(hash = 1779482587)
    public PlanterViewDBModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getmDataFrom() {
        return mDataFrom;
    }

    public void setmDataFrom(int mDataFrom) {
        this.mDataFrom = mDataFrom;
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

    public int getMDataFrom() {
        return this.mDataFrom;
    }

    public void setMDataFrom(int mDataFrom) {
        this.mDataFrom = mDataFrom;
    }

    public String getMCourseId() {
        return this.mCourseId;
    }

    public void setMCourseId(String mCourseId) {
        this.mCourseId = mCourseId;
    }

    public int getMModuleId() {
        return this.mModuleId;
    }

    public void setMModuleId(int mModuleId) {
        this.mModuleId = mModuleId;
    }

    public int getMActionId() {
        return this.mActionId;
    }

    public void setMActionId(int mActionId) {
        this.mActionId = mActionId;
    }

    public String getMTeacherId() {
        return this.mTeacherId;
    }

    public void setMTeacherId(String mTeacherId) {
        this.mTeacherId = mTeacherId;
    }

    public String getMStudentId() {
        return this.mStudentId;
    }

    public void setMStudentId(String mStudentId) {
        this.mStudentId = mStudentId;
    }

    public int getMPlanterStatus() {
        return this.mPlanterStatus;
    }

    public void setMPlanterStatus(int mPlanterStatus) {
        this.mPlanterStatus = mPlanterStatus;
    }

    public String getMCourseName() {
        return this.mCourseName;
    }

    public void setMCourseName(String mCourseName) {
        this.mCourseName = mCourseName;
    }

    public String getMCourseTime() {
        return this.mCourseTime;
    }

    public void setMCourseTime(String mCourseTime) {
        this.mCourseTime = mCourseTime;
    }

    public int getMPlanterSunshine() {
        return this.mPlanterSunshine;
    }

    public void setMPlanterSunshine(int mPlanterSunshine) {
        this.mPlanterSunshine = mPlanterSunshine;
    }

    public int getMPlanterWater() {
        return this.mPlanterWater;
    }

    public void setMPlanterWater(int mPlanterWater) {
        this.mPlanterWater = mPlanterWater;
    }

    public int getMPlanterSoil() {
        return this.mPlanterSoil;
    }

    public void setMPlanterSoil(int mPlanterSoil) {
        this.mPlanterSoil = mPlanterSoil;
    }

    public int getMPlanterPercent() {
        return this.mPlanterPercent;
    }

    public void setMPlanterPercent(int mPlanterPercent) {
        this.mPlanterPercent = mPlanterPercent;
    }
}
