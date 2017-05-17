package com.gdufs.planter.module.summary.model;

import com.gdufs.planter.common.BaseViewDBModel;
import com.gdufs.planter.common.Resource;
import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by peng on 2017/4/10.
 */
@Entity
public class SummaryViewDBModel extends BaseViewDBModel{

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

    @Generated(hash = 109596238)
    public SummaryViewDBModel(Long id, int mDataFrom, String mCourseId,
            int mModuleId, int mActionId, String mTeacherId, String mStudentId,
            String mSummaryId, String mSummaryRequestTime, int mSummaryBonusNum,
            int mSummaryBonusType, String mSummaryContent, int mSummaryStatus,
            String mOpenClassId) {
        this.id = id;
        this.mDataFrom = mDataFrom;
        this.mCourseId = mCourseId;
        this.mModuleId = mModuleId;
        this.mActionId = mActionId;
        this.mTeacherId = mTeacherId;
        this.mStudentId = mStudentId;
        this.mSummaryId = mSummaryId;
        this.mSummaryRequestTime = mSummaryRequestTime;
        this.mSummaryBonusNum = mSummaryBonusNum;
        this.mSummaryBonusType = mSummaryBonusType;
        this.mSummaryContent = mSummaryContent;
        this.mSummaryStatus = mSummaryStatus;
        this.mOpenClassId = mOpenClassId;
    }

    @Generated(hash = 1978998625)
    public SummaryViewDBModel() {
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

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getMSummaryRequestTime() {
        return this.mSummaryRequestTime;
    }

    public void setMSummaryRequestTime(String mSummaryRequestTime) {
        this.mSummaryRequestTime = mSummaryRequestTime;
    }

    public int getMSummaryBonusNum() {
        return this.mSummaryBonusNum;
    }

    public void setMSummaryBonusNum(int mSummaryBonusNum) {
        this.mSummaryBonusNum = mSummaryBonusNum;
    }

    public String getMSummaryContent() {
        return this.mSummaryContent;
    }

    public void setMSummaryContent(String mSummaryContent) {
        this.mSummaryContent = mSummaryContent;
    }

    public int getMSummaryStatus() {
        return this.mSummaryStatus;
    }

    public void setMSummaryStatus(int mSummaryStatus) {
        this.mSummaryStatus = mSummaryStatus;
    }

    public String getMSummaryId() {
        return this.mSummaryId;
    }

    public void setMSummaryId(String mSummaryId) {
        this.mSummaryId = mSummaryId;
    }

    public int getMSummaryBonusType() {
        return this.mSummaryBonusType;
    }

    public void setMSummaryBonusType(int mSummaryBonusType) {
        this.mSummaryBonusType = mSummaryBonusType;
    }

    public String getMOpenClassId() {
        return this.mOpenClassId;
    }

    public void setMOpenClassId(String mOpenClassId) {
        this.mOpenClassId = mOpenClassId;
    }
}
