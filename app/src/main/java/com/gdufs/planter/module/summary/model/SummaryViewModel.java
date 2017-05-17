package com.gdufs.planter.module.summary.model;

import com.gdufs.planter.common.BaseViewModel;
import com.gdufs.planter.common.Resource;
import com.google.gson.annotations.SerializedName;

/**
 * Created by peng on 2017/3/20.
 */

public class SummaryViewModel extends BaseViewModel {

    @SerializedName(Resource.KEY.KEY_SUMMARY_ID)
    private String mSummaryId;

    @SerializedName(Resource.KEY.KEY_SUMMARY_REQUEST_TIME)
    private String mSummaryRequestTime;

    @SerializedName(Resource.KEY.KEY_SUMMARY_BONUS_NUM)
    private int mSummaryBonusNum;

    @SerializedName(Resource.KEY.KEY_BONUS_TYPE)
    private int mSummaryBonusType;

    @SerializedName(Resource.KEY.KEY_SUMMARY_CONTENT)
    private String mSummaryContent;

    @SerializedName(Resource.KEY.KEY_SUMMARY_STATUS)
    private int mSummaryStatus;

    @SerializedName(Resource.KEY.KEY_CLASS_OPEN_ID)
    private String mOpenClassId;

    public String getmOpenClassId() {
        return mOpenClassId;
    }

    public void setmOpenClassId(String mOpenClassId) {
        this.mOpenClassId = mOpenClassId;
    }

    public int getmSummaryBonusType() {
        return mSummaryBonusType;
    }

    public void setmSummaryBonusType(int mSummaryBonusType) {
        this.mSummaryBonusType = mSummaryBonusType;
    }

    public String getmSummaryId() {
        return mSummaryId;
    }

    public void setmSummaryId(String mSummaryId) {
        this.mSummaryId = mSummaryId;
    }

    public String getmSummaryRequestTime() {
        return mSummaryRequestTime;
    }

    public void setmSummaryRequestTime(String mSummaryRequestTime) {
        this.mSummaryRequestTime = mSummaryRequestTime;
    }

    public int getmSummaryBonusNum() {
        return mSummaryBonusNum;
    }

    public void setmSummaryBonusNum(int mSummaryBonusNum) {
        this.mSummaryBonusNum = mSummaryBonusNum;
    }

    public String getmSummaryContent() {
        return mSummaryContent;
    }

    public void setmSummaryContent(String mSummaryContent) {
        this.mSummaryContent = mSummaryContent;
    }

    public int getmSummaryStatus() {
        return mSummaryStatus;
    }

    public void setmSummaryStatus(int mSummaryStatus) {
        this.mSummaryStatus = mSummaryStatus;
    }
}
