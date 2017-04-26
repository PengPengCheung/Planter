package com.gdufs.planter.module.attention.model;

import android.os.Parcelable;

import com.gdufs.planter.common.BaseViewModel;
import com.gdufs.planter.common.Resource;
import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by peng on 2017/3/20.
 */

public class AttentionViewModel extends BaseViewModel {

    @SerializedName(Resource.KEY.KEY_ATTENTION_ID)
    private String mAttentionId;

    @SerializedName(Resource.KEY.KEY_ATTENTION_TIME)
    private String mAttentionTime;

    @SerializedName(Resource.KEY.KEY_ATTENTION_DURATION)
    private String mAttentionDuration;

    @SerializedName(Resource.KEY.KEY_ATTENTION_FOCUS_COUNT)
    private int mAttentionFocusCount;

    @SerializedName(Resource.KEY.KEY_ATTENTION_LOST_FOCUS_COUNT)
    private int mAttentionLostFocusCount;

    @SerializedName(Resource.KEY.KEY_ATTENTION_BONUS_NUM)
    private int mAttentionBonusNum;

    @SerializedName(Resource.KEY.KEY_BONUS_TYPE)
    private int mAttentionBonusType;

    @SerializedName(Resource.KEY.KEY_ATTENTION_STATUS)
    private int mAttentionStatus;

    @SerializedName(Resource.KEY.KEY_CLASS_OPEN_ID)
    private String mOpenClassId;

    @SerializedName(Resource.KEY.KEY_ATTENTION_TYPE)
    private int mAttentionType;

    public int getmAttentionType() {
        return mAttentionType;
    }

    public void setmAttentionType(int mAttentionType) {
        this.mAttentionType = mAttentionType;
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

    public String getmAttentionId() {
        return mAttentionId;
    }

    public void setmAttentionId(String mAttentionId) {
        this.mAttentionId = mAttentionId;
    }

    public int getmAttentionStatus() {
        return mAttentionStatus;
    }

    public void setmAttentionStatus(int mAttentionStatus) {
        this.mAttentionStatus = mAttentionStatus;
    }

    public String getmAttentionTime() {
        return mAttentionTime;
    }

    public void setmAttentionTime(String mAttentionTime) {
        this.mAttentionTime = mAttentionTime;
    }

    public String getmAttentionDuration() {
        return mAttentionDuration;
    }

    public void setmAttentionDuration(String mAttentionDuration) {
        this.mAttentionDuration = mAttentionDuration;
    }

    public int getmAttentionFocusCount() {
        return mAttentionFocusCount;
    }

    public void setmAttentionFocusCount(int mAttentionFocusCount) {
        this.mAttentionFocusCount = mAttentionFocusCount;
    }

    public int getmAttentionLostFocusCount() {
        return mAttentionLostFocusCount;
    }

    public void setmAttentionLostFocusCount(int mAttentionLostFocusCount) {
        this.mAttentionLostFocusCount = mAttentionLostFocusCount;
    }

    public int getmAttentionBonusNum() {
        return mAttentionBonusNum;
    }

    public void setmAttentionBonusNum(int mAttentionBonusNum) {
        this.mAttentionBonusNum = mAttentionBonusNum;
    }

    public String getMAttentionId() {
        return this.mAttentionId;
    }

    public void setMAttentionId(String mAttentionId) {
        this.mAttentionId = mAttentionId;
    }

    public String getMAttentionTime() {
        return this.mAttentionTime;
    }

    public void setMAttentionTime(String mAttentionTime) {
        this.mAttentionTime = mAttentionTime;
    }

    public String getMAttentionDuration() {
        return this.mAttentionDuration;
    }

    public void setMAttentionDuration(String mAttentionDuration) {
        this.mAttentionDuration = mAttentionDuration;
    }

    public int getMAttentionFocusCount() {
        return this.mAttentionFocusCount;
    }

    public void setMAttentionFocusCount(int mAttentionFocusCount) {
        this.mAttentionFocusCount = mAttentionFocusCount;
    }

    public int getMAttentionLostFocusCount() {
        return this.mAttentionLostFocusCount;
    }

    public void setMAttentionLostFocusCount(int mAttentionLostFocusCount) {
        this.mAttentionLostFocusCount = mAttentionLostFocusCount;
    }

    public int getMAttentionBonusNum() {
        return this.mAttentionBonusNum;
    }

    public void setMAttentionBonusNum(int mAttentionBonusNum) {
        this.mAttentionBonusNum = mAttentionBonusNum;
    }

    public int getMAttentionStatus() {
        return this.mAttentionStatus;
    }

    public void setMAttentionStatus(int mAttentionStatus) {
        this.mAttentionStatus = mAttentionStatus;
    }
}
