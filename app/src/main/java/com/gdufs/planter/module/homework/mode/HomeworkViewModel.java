package com.gdufs.planter.module.homework.mode;

import com.gdufs.planter.common.BaseViewModel;
import com.gdufs.planter.common.Resource;
import com.google.gson.annotations.SerializedName;

/**
 * Created by peng on 2017/3/21.
 */

public class HomeworkViewModel extends BaseViewModel {

    @SerializedName(Resource.KEY.KEY_HOMEWORK_PUBLISH_TIME)
    private String mHomeworkPublishTime; // 老师发布作业的时间

    @SerializedName(Resource.KEY.KEY_HOMEWORK_SUBMIT_DDL)
    private String mHomeworkSubmitDDL;

    @SerializedName(Resource.KEY.KEY_HOMEWORK_CURRENT_TIME)
    private String mHomeworkItemCurrentTime; // 学生提交作业的时间，老师打分的时间

    @SerializedName(Resource.KEY.KEY_HOMEWORK_STATUS)
    private int mHomeworkStatus;

    @SerializedName(Resource.KEY.KEY_HOMEWORK_SCORE)
    private int mHomeworkScore;

    @SerializedName(Resource.KEY.KEY_HOMEWORK_RANK)
    private int mHomeworkRank;

    @SerializedName(Resource.KEY.KEY_HOMEWORK_BONUS_NUM)
    private int mHomeworkBonusNum;

    @SerializedName(Resource.KEY.KEY_HOMEWORK_TITLE)
    private String mHomeworkTitle;

    @SerializedName(Resource.KEY.KEY_HOMEWORK_CONTENT)
    private String mHomeworkContent;

    public String getmHomeworkTitle() {
        return mHomeworkTitle;
    }

    public void setmHomeworkTitle(String mHomeworkTitle) {
        this.mHomeworkTitle = mHomeworkTitle;
    }

    public String getmHomeworkContent() {
        return mHomeworkContent;
    }

    public void setmHomeworkContent(String mHomeworkContent) {
        this.mHomeworkContent = mHomeworkContent;
    }

    public String getmHomeworkPublishTime() {
        return mHomeworkPublishTime;
    }

    public void setmHomeworkPublishTime(String mHomeworkPublishTime) {
        this.mHomeworkPublishTime = mHomeworkPublishTime;
    }

    public String getmHomeworkSubmitDDL() {
        return mHomeworkSubmitDDL;
    }

    public void setmHomeworkSubmitDDL(String mHomeworkSubmitDDL) {
        this.mHomeworkSubmitDDL = mHomeworkSubmitDDL;
    }

    public String getmHomeworkItemCurrentTime() {
        return mHomeworkItemCurrentTime;
    }

    public void setmHomeworkItemCurrentTime(String mHomeworkItemCurrentTime) {
        this.mHomeworkItemCurrentTime = mHomeworkItemCurrentTime;
    }

    public int getmHomeworkStatus() {
        return mHomeworkStatus;
    }

    public void setmHomeworkStatus(int mHomeworkStatus) {
        this.mHomeworkStatus = mHomeworkStatus;
    }

    public int getmHomeworkScore() {
        return mHomeworkScore;
    }

    public void setmHomeworkScore(int mHomeworkScore) {
        this.mHomeworkScore = mHomeworkScore;
    }

    public int getmHomeworkRank() {
        return mHomeworkRank;
    }

    public void setmHomeworkRank(int mHomeworkRank) {
        this.mHomeworkRank = mHomeworkRank;
    }

    public int getmHomeworkBonusNum() {
        return mHomeworkBonusNum;
    }

    public void setmHomeworkBonusNum(int mHomeworkBonusNum) {
        this.mHomeworkBonusNum = mHomeworkBonusNum;
    }
}
