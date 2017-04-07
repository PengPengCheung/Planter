package com.gdufs.planter.module.planter.model;

import com.gdufs.planter.common.BaseViewDBModel;
import com.gdufs.planter.common.Resource;
import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by peng on 2017/4/7.
 */

@Entity
public class PlanterDetailViewDBModel extends BaseViewDBModel{

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

    @SerializedName(Resource.KEY.KEY_PLANTER_USED_WATER)
    private int mPlanterWaterUsed;

    @SerializedName(Resource.KEY.KEY_PLANTER_USED_SUNSHINE)
    private int mPlanterSunshineUsed;

    @SerializedName(Resource.KEY.KEY_PLANTER_USED_SOIL)
    private int mPlanterSoilUsed;

    @SerializedName(Resource.KEY.KEY_PLANTER_RANK)
    private int mPlanterRank;

    @SerializedName(Resource.KEY.KEY_PLANTER_EVALUATION)
    private int mPlanterEvaluation; // 对当前成长树状态的评估

    @SerializedName(Resource.KEY.KEY_PLANTER_TITLE)
    private String mPlanterTitle; // 系统认证称号

    @Generated(hash = 1654450590)
    public PlanterDetailViewDBModel(Long id, int mDataFrom, String mCourseId,
            int mModuleId, int mActionId, String mTeacherId, String mStudentId,
            int mPlanterStatus, int mPlanterWaterUsed, int mPlanterSunshineUsed,
            int mPlanterSoilUsed, int mPlanterRank, int mPlanterEvaluation,
            String mPlanterTitle) {
        this.id = id;
        this.mDataFrom = mDataFrom;
        this.mCourseId = mCourseId;
        this.mModuleId = mModuleId;
        this.mActionId = mActionId;
        this.mTeacherId = mTeacherId;
        this.mStudentId = mStudentId;
        this.mPlanterStatus = mPlanterStatus;
        this.mPlanterWaterUsed = mPlanterWaterUsed;
        this.mPlanterSunshineUsed = mPlanterSunshineUsed;
        this.mPlanterSoilUsed = mPlanterSoilUsed;
        this.mPlanterRank = mPlanterRank;
        this.mPlanterEvaluation = mPlanterEvaluation;
        this.mPlanterTitle = mPlanterTitle;
    }

    @Generated(hash = 1609745589)
    public PlanterDetailViewDBModel() {
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

    public int getmPlanterWaterUsed() {
        return mPlanterWaterUsed;
    }

    public void setmPlanterWaterUsed(int mPlanterWaterUsed) {
        this.mPlanterWaterUsed = mPlanterWaterUsed;
    }

    public int getmPlanterSunshineUsed() {
        return mPlanterSunshineUsed;
    }

    public void setmPlanterSunshineUsed(int mPlanterSunshineUsed) {
        this.mPlanterSunshineUsed = mPlanterSunshineUsed;
    }

    public int getmPlanterSoilUsed() {
        return mPlanterSoilUsed;
    }

    public void setmPlanterSoilUsed(int mPlanterSoilUsed) {
        this.mPlanterSoilUsed = mPlanterSoilUsed;
    }

    public int getmPlanterRank() {
        return mPlanterRank;
    }

    public void setmPlanterRank(int mPlanterRank) {
        this.mPlanterRank = mPlanterRank;
    }

    public int getmPlanterEvaluation() {
        return mPlanterEvaluation;
    }

    public void setmPlanterEvaluation(int mPlanterEvaluation) {
        this.mPlanterEvaluation = mPlanterEvaluation;
    }

    public String getmPlanterTitle() {
        return mPlanterTitle;
    }

    public void setmPlanterTitle(String mPlanterTitle) {
        this.mPlanterTitle = mPlanterTitle;
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

    public int getMPlanterWaterUsed() {
        return this.mPlanterWaterUsed;
    }

    public void setMPlanterWaterUsed(int mPlanterWaterUsed) {
        this.mPlanterWaterUsed = mPlanterWaterUsed;
    }

    public int getMPlanterSunshineUsed() {
        return this.mPlanterSunshineUsed;
    }

    public void setMPlanterSunshineUsed(int mPlanterSunshineUsed) {
        this.mPlanterSunshineUsed = mPlanterSunshineUsed;
    }

    public int getMPlanterSoilUsed() {
        return this.mPlanterSoilUsed;
    }

    public void setMPlanterSoilUsed(int mPlanterSoilUsed) {
        this.mPlanterSoilUsed = mPlanterSoilUsed;
    }

    public int getMPlanterRank() {
        return this.mPlanterRank;
    }

    public void setMPlanterRank(int mPlanterRank) {
        this.mPlanterRank = mPlanterRank;
    }

    public int getMPlanterEvaluation() {
        return this.mPlanterEvaluation;
    }

    public void setMPlanterEvaluation(int mPlanterEvaluation) {
        this.mPlanterEvaluation = mPlanterEvaluation;
    }

    public String getMPlanterTitle() {
        return this.mPlanterTitle;
    }

    public void setMPlanterTitle(String mPlanterTitle) {
        this.mPlanterTitle = mPlanterTitle;
    }
}
