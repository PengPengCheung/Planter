package com.gdufs.planter.module.attention.model;

import com.gdufs.planter.common.BaseViewDBModel;
import com.gdufs.planter.common.Resource;
import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by peng on 2017/4/8.
 */

@Entity
public class AttentionViewDBModel extends BaseViewDBModel {

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

    @SerializedName(Resource.KEY.KEY_ATTENTION_STATUS)
    private int mAttentionStatus;

    @SerializedName(Resource.KEY.KEY_BONUS_TYPE)
    private int mAttentionBonusType;

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

    @Generated(hash = 2072540728)
    public AttentionViewDBModel(Long id, int mDataFrom, String mCourseId,
            int mModuleId, int mActionId, String mTeacherId, String mStudentId,
            String mAttentionId, String mAttentionTime, String mAttentionDuration,
            int mAttentionFocusCount, int mAttentionLostFocusCount,
            int mAttentionBonusNum, int mAttentionStatus, int mAttentionBonusType,
            String mOpenClassId, int mAttentionType) {
        this.id = id;
        this.mDataFrom = mDataFrom;
        this.mCourseId = mCourseId;
        this.mModuleId = mModuleId;
        this.mActionId = mActionId;
        this.mTeacherId = mTeacherId;
        this.mStudentId = mStudentId;
        this.mAttentionId = mAttentionId;
        this.mAttentionTime = mAttentionTime;
        this.mAttentionDuration = mAttentionDuration;
        this.mAttentionFocusCount = mAttentionFocusCount;
        this.mAttentionLostFocusCount = mAttentionLostFocusCount;
        this.mAttentionBonusNum = mAttentionBonusNum;
        this.mAttentionStatus = mAttentionStatus;
        this.mAttentionBonusType = mAttentionBonusType;
        this.mOpenClassId = mOpenClassId;
        this.mAttentionType = mAttentionType;
    }

    @Generated(hash = 978246602)
    public AttentionViewDBModel() {
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

    public String getmAttentionId() {
        return mAttentionId;
    }

    public void setmAttentionId(String mAttentionId) {
        this.mAttentionId = mAttentionId;
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

    public int getmAttentionStatus() {
        return mAttentionStatus;
    }

    public void setmAttentionStatus(int mAttentionStatus) {
        this.mAttentionStatus = mAttentionStatus;
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

    public int getMAttentionBonusType() {
        return this.mAttentionBonusType;
    }

    public void setMAttentionBonusType(int mAttentionBonusType) {
        this.mAttentionBonusType = mAttentionBonusType;
    }

    public String getMOpenClassId() {
        return this.mOpenClassId;
    }

    public void setMOpenClassId(String mOpenClassId) {
        this.mOpenClassId = mOpenClassId;
    }

    public int getMAttentionType() {
        return this.mAttentionType;
    }

    public void setMAttentionType(int mAttentionType) {
        this.mAttentionType = mAttentionType;
    }
}
