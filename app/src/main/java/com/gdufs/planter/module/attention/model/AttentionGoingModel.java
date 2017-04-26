package com.gdufs.planter.module.attention.model;

import com.gdufs.planter.common.BaseViewModel;
import com.gdufs.planter.common.Resource;
import com.google.gson.annotations.SerializedName;

public class AttentionGoingModel extends BaseViewModel {

    @SerializedName(Resource.KEY.KEY_STUDENT_ID)
    private String mStudentId;

    @SerializedName(Resource.KEY.KEY_STU_NAME)
    private String mStudentName;

    @SerializedName(Resource.KEY.KEY_ATTENTION_INSIST_TIME)
    private int mAttentionInsistTime; // 单位是毫秒

    @SerializedName(Resource.KEY.KEY_ATTENTION_STATUS)
    private int mAttentionStatus;

    @SerializedName(Resource.KEY.KEY_ATTENTION_TYPE)
    private int mAttentionType;

    @SerializedName(Resource.KEY.KEY_BONUS_TYPE)
    private int mAttentionBonusType;

    @SerializedName(Resource.KEY.KEY_ATTENTION_BONUS_NUM)
    private int mAttentionBonusNum;

    @SerializedName(Resource.KEY.KEY_ATTENTION_DURATION)
    private String mAttentionDuration;

    @SerializedName(Resource.KEY.KEY_ATTENTION_SCORE)
    private int mScore = -1; // 小组专注时才有值

    @SerializedName(Resource.KEY.KEY_CLASS_OPEN_ID)
    private String mOpenClassId;

    @SerializedName(Resource.KEY.KEY_ATTENTION_TIME)
    private String mStartTime;

    @SerializedName(Resource.KEY.KEY_ATTENTION_END_TIME)
    private String mEndTime;

    @Override
    public String getmStudentId() {
        return mStudentId;
    }

    @Override
    public void setmStudentId(String mStudentId) {
        this.mStudentId = mStudentId;
    }

    public String getmStartTime() {
        return mStartTime;
    }

    public void setmStartTime(String mStartTime) {
        this.mStartTime = mStartTime;
    }

    public String getmEndTime() {
        return mEndTime;
    }

    public void setmEndTime(String mEndTime) {
        this.mEndTime = mEndTime;
    }

    public String getmOpenClassId() {
        return mOpenClassId;
    }

    public void setmOpenClassId(String mOpenClassId) {
        this.mOpenClassId = mOpenClassId;
    }

    public int getmAttentionBonusType() {
        return mAttentionBonusType;
    }

    public void setmAttentionBonusType(int mAttentionBonusType) {
        this.mAttentionBonusType = mAttentionBonusType;
    }

    public int getmAttentionBonusNum() {
        return mAttentionBonusNum;
    }

    public void setmAttentionBonusNum(int mAttentionBonusNum) {
        this.mAttentionBonusNum = mAttentionBonusNum;
    }

    public String getmAttentionDuration() {
        return mAttentionDuration;
    }

    public void setmAttentionDuration(String mAttentionDuration) {
        this.mAttentionDuration = mAttentionDuration;
    }

    public String getmStudentName() {
        return mStudentName;
    }

    public void setmStudentName(String mStudentName) {
        this.mStudentName = mStudentName;
    }

    public int getmAttentionInsistTime() {
        return mAttentionInsistTime;
    }

    public void setmAttentionInsistTime(int mAttentionInsistTime) {
        this.mAttentionInsistTime = mAttentionInsistTime;
    }

    public int getmAttentionStatus() {
        return mAttentionStatus;
    }

    public void setmAttentionStatus(int mAttentionStatus) {
        this.mAttentionStatus = mAttentionStatus;
    }

    public int getmAttentionType() {
        return mAttentionType;
    }

    public void setmAttentionType(int mAttentionType) {
        this.mAttentionType = mAttentionType;
    }

    public int getmScore() {
        return mScore;
    }

    public void setmScore(int mScore) {
        this.mScore = mScore;
    }
}