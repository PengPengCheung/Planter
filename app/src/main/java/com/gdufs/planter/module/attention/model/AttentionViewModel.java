package com.gdufs.planter.module.attention.model;

import com.gdufs.planter.common.BaseViewModel;
import com.gdufs.planter.common.Resource;
import com.google.gson.annotations.SerializedName;

/**
 * Created by peng on 2017/3/20.
 */

public class AttentionViewModel extends BaseViewModel {

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

    @SerializedName(Resource.KEY.KEY_ATTENTION_STATUS)
    private int mAttentionStatus;

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
}
