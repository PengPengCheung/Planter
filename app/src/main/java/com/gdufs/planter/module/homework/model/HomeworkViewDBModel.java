package com.gdufs.planter.module.homework.model;

import com.gdufs.planter.common.BaseViewDBModel;
import com.gdufs.planter.common.Resource;
import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by peng on 2017/4/14.
 */

@Entity
public class HomeworkViewDBModel extends BaseViewDBModel{

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

    @SerializedName(Resource.KEY.KEY_HOMEWORK_ID)
    private String mHomeworkId;

    @SerializedName(Resource.KEY.KEY_HOMEWORK_STATUS)
    private int mHomeworkStatus;

    @SerializedName(Resource.KEY.KEY_HOMEWORK_TITLE)
    private String mHomeworkTitle;

    @SerializedName(Resource.KEY.KEY_HOMEWORK_CONTENT)
    private String mHomeworkContent;

    // 教师发布作业但学生未提交
    @SerializedName(Resource.KEY.KEY_HOMEWORK_SUBMIT_DDL)
    private String mHomeworkSubmitDDL;

    @SerializedName(Resource.KEY.KEY_HOMEWORK_PUBLISH_TIME)
    private String mHomeworkPublishTime; // 老师发布作业的时间


    // 学生提交作业但教师未评分
    @SerializedName(Resource.KEY.KEY_HOMEWORK_CURRENT_TIME)
    private String mHomeworkItemCurrentTime; // 学生提交作业的时间，老师打分的时间


    // 教师已对作业打分
    @SerializedName(Resource.KEY.KEY_HOMEWORK_SCORE)
    private int mHomeworkScore;

    @SerializedName(Resource.KEY.KEY_HOMEWORK_RANK)
    private int mHomeworkRank;

    @SerializedName(Resource.KEY.KEY_HOMEWORK_BONUS_NUM)
    private int mHomeworkBonusNum;



    @Generated(hash = 1678414723)
    public HomeworkViewDBModel(Long id, int mDataFrom, String mCourseId,
            int mModuleId, int mActionId, String mTeacherId, String mStudentId,
            String mHomeworkId, int mHomeworkStatus, String mHomeworkTitle,
            String mHomeworkContent, String mHomeworkSubmitDDL,
            String mHomeworkPublishTime, String mHomeworkItemCurrentTime,
            int mHomeworkScore, int mHomeworkRank, int mHomeworkBonusNum) {
        this.id = id;
        this.mDataFrom = mDataFrom;
        this.mCourseId = mCourseId;
        this.mModuleId = mModuleId;
        this.mActionId = mActionId;
        this.mTeacherId = mTeacherId;
        this.mStudentId = mStudentId;
        this.mHomeworkId = mHomeworkId;
        this.mHomeworkStatus = mHomeworkStatus;
        this.mHomeworkTitle = mHomeworkTitle;
        this.mHomeworkContent = mHomeworkContent;
        this.mHomeworkSubmitDDL = mHomeworkSubmitDDL;
        this.mHomeworkPublishTime = mHomeworkPublishTime;
        this.mHomeworkItemCurrentTime = mHomeworkItemCurrentTime;
        this.mHomeworkScore = mHomeworkScore;
        this.mHomeworkRank = mHomeworkRank;
        this.mHomeworkBonusNum = mHomeworkBonusNum;
    }

    @Generated(hash = 397468496)
    public HomeworkViewDBModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getmHomeworkId() {
        return mHomeworkId;
    }

    public void setmHomeworkId(String mHomeworkId) {
        this.mHomeworkId = mHomeworkId;
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

    public String getMHomeworkId() {
        return this.mHomeworkId;
    }

    public void setMHomeworkId(String mHomeworkId) {
        this.mHomeworkId = mHomeworkId;
    }

    public String getMHomeworkPublishTime() {
        return this.mHomeworkPublishTime;
    }

    public void setMHomeworkPublishTime(String mHomeworkPublishTime) {
        this.mHomeworkPublishTime = mHomeworkPublishTime;
    }

    public String getMHomeworkSubmitDDL() {
        return this.mHomeworkSubmitDDL;
    }

    public void setMHomeworkSubmitDDL(String mHomeworkSubmitDDL) {
        this.mHomeworkSubmitDDL = mHomeworkSubmitDDL;
    }

    public String getMHomeworkItemCurrentTime() {
        return this.mHomeworkItemCurrentTime;
    }

    public void setMHomeworkItemCurrentTime(String mHomeworkItemCurrentTime) {
        this.mHomeworkItemCurrentTime = mHomeworkItemCurrentTime;
    }

    public int getMHomeworkStatus() {
        return this.mHomeworkStatus;
    }

    public void setMHomeworkStatus(int mHomeworkStatus) {
        this.mHomeworkStatus = mHomeworkStatus;
    }

    public int getMHomeworkScore() {
        return this.mHomeworkScore;
    }

    public void setMHomeworkScore(int mHomeworkScore) {
        this.mHomeworkScore = mHomeworkScore;
    }

    public int getMHomeworkRank() {
        return this.mHomeworkRank;
    }

    public void setMHomeworkRank(int mHomeworkRank) {
        this.mHomeworkRank = mHomeworkRank;
    }

    public int getMHomeworkBonusNum() {
        return this.mHomeworkBonusNum;
    }

    public void setMHomeworkBonusNum(int mHomeworkBonusNum) {
        this.mHomeworkBonusNum = mHomeworkBonusNum;
    }

    public String getMHomeworkTitle() {
        return this.mHomeworkTitle;
    }

    public void setMHomeworkTitle(String mHomeworkTitle) {
        this.mHomeworkTitle = mHomeworkTitle;
    }

    public String getMHomeworkContent() {
        return this.mHomeworkContent;
    }

    public void setMHomeworkContent(String mHomeworkContent) {
        this.mHomeworkContent = mHomeworkContent;
    }
}
