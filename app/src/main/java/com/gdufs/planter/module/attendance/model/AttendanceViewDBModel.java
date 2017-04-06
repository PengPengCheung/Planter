package com.gdufs.planter.module.attendance.model;

import com.gdufs.planter.common.BaseViewDBModel;
import com.gdufs.planter.common.BaseViewModel;
import com.gdufs.planter.common.Resource;
import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;


@Entity
public class AttendanceViewDBModel extends BaseViewDBModel {

    @Id
    private Long id;

    @SerializedName(Resource.KEY.KEY_DATA_GET_METHOD)
    private int mDataFrom;

    @SerializedName(Resource.KEY.KEY_COURSE_ID)
    private String mCourseId;

    @SerializedName(Resource.KEY.KEY_MODULE_ID)
    private int mModuleId;

    @SerializedName(Resource.KEY.KEY_ACTION_ID)
    private int mActionId;

    @SerializedName(Resource.KEY.KEY_TEACHER_ID)
    private String mTeacherId;

    @SerializedName(Resource.KEY.KEY_STUDENT_ID)
    private String mStudentId;

    @SerializedName(Resource.KEY.KEY_ATTENDANCE_ID)
    private String attendanceId;

    @SerializedName(Resource.KEY.KEY_ATTENDANCE_TIME)
    private String mAttendanceTime;

    @SerializedName(Resource.KEY.KEY_ATTENDANCE_ATT_COUNT)
    private int mAttendanceCount;

    @SerializedName(Resource.KEY.KEY_ATTENDANCE_ABS_COUNT)
    private int mAbsenceCount;

    @SerializedName(Resource.KEY.KEY_ATTENDANCE_VALID_DURATION)
    private String mAttendanceValidDuration;

    @SerializedName(Resource.KEY.KEY_ATTENDANCE_BONUS_NUM)
    private int mAttendanceBonusNum;

    @SerializedName(Resource.KEY.KEY_ATTENDANCE_CODE)
    private String mAttendanceCode;

    @SerializedName(Resource.KEY.KEY_ATTENDANCE_STATUS)
    private int mAttendanceStatus;


    @Generated(hash = 1695644791)
    public AttendanceViewDBModel(Long id, int mDataFrom, String mCourseId, int mModuleId,
            int mActionId, String mTeacherId, String mStudentId, String attendanceId,
            String mAttendanceTime, int mAttendanceCount, int mAbsenceCount,
            String mAttendanceValidDuration, int mAttendanceBonusNum, String mAttendanceCode,
            int mAttendanceStatus) {
        this.id = id;
        this.mDataFrom = mDataFrom;
        this.mCourseId = mCourseId;
        this.mModuleId = mModuleId;
        this.mActionId = mActionId;
        this.mTeacherId = mTeacherId;
        this.mStudentId = mStudentId;
        this.attendanceId = attendanceId;
        this.mAttendanceTime = mAttendanceTime;
        this.mAttendanceCount = mAttendanceCount;
        this.mAbsenceCount = mAbsenceCount;
        this.mAttendanceValidDuration = mAttendanceValidDuration;
        this.mAttendanceBonusNum = mAttendanceBonusNum;
        this.mAttendanceCode = mAttendanceCode;
        this.mAttendanceStatus = mAttendanceStatus;
    }

    @Generated(hash = 1090463366)
    public AttendanceViewDBModel() {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(String attendanceId) {
        this.attendanceId = attendanceId;
    }

    public int getmAttendanceStatus() {
        return mAttendanceStatus;
    }

    public void setmAttendanceStatus(int mAttendanceStatus) {
        this.mAttendanceStatus = mAttendanceStatus;
    }

    public String getmAttendanceTime() {
        return mAttendanceTime;
    }

    public void setmAttendanceTime(String mAttendanceTime) {
        this.mAttendanceTime = mAttendanceTime;
    }

    public int getmAttendanceCount() {
        return mAttendanceCount;
    }

    public void setmAttendanceCount(int mAttendanceCount) {
        this.mAttendanceCount = mAttendanceCount;
    }

    public int getmAbsenceCount() {
        return mAbsenceCount;
    }

    public void setmAbsenceCount(int mAbsenceCount) {
        this.mAbsenceCount = mAbsenceCount;
    }

    public String getmAttendanceValidDuration() {
        return mAttendanceValidDuration;
    }

    public void setmAttendanceValidDuration(String mAttendanceValidDuration) {
        this.mAttendanceValidDuration = mAttendanceValidDuration;
    }

    public int getmAttendanceBonusNum() {
        return mAttendanceBonusNum;
    }

    public void setmAttendanceBonusNum(int mAttendanceBonusNum) {
        this.mAttendanceBonusNum = mAttendanceBonusNum;
    }

    public String getmAttendanceCode() {
        return mAttendanceCode;
    }

    public void setmAttendanceCode(String mAttendanceCode) {
        this.mAttendanceCode = mAttendanceCode;
    }

    public String getMAttendanceTime() {
        return this.mAttendanceTime;
    }

    public void setMAttendanceTime(String mAttendanceTime) {
        this.mAttendanceTime = mAttendanceTime;
    }

    public int getMAttendanceCount() {
        return this.mAttendanceCount;
    }

    public void setMAttendanceCount(int mAttendanceCount) {
        this.mAttendanceCount = mAttendanceCount;
    }

    public int getMAbsenceCount() {
        return this.mAbsenceCount;
    }

    public void setMAbsenceCount(int mAbsenceCount) {
        this.mAbsenceCount = mAbsenceCount;
    }

    public String getMAttendanceValidDuration() {
        return this.mAttendanceValidDuration;
    }

    public void setMAttendanceValidDuration(String mAttendanceValidDuration) {
        this.mAttendanceValidDuration = mAttendanceValidDuration;
    }

    public int getMAttendanceBonusNum() {
        return this.mAttendanceBonusNum;
    }

    public void setMAttendanceBonusNum(int mAttendanceBonusNum) {
        this.mAttendanceBonusNum = mAttendanceBonusNum;
    }

    public String getMAttendanceCode() {
        return this.mAttendanceCode;
    }

    public void setMAttendanceCode(String mAttendanceCode) {
        this.mAttendanceCode = mAttendanceCode;
    }

    public int getMAttendanceStatus() {
        return this.mAttendanceStatus;
    }

    public void setMAttendanceStatus(int mAttendanceStatus) {
        this.mAttendanceStatus = mAttendanceStatus;
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

    public int getMDataFrom() {
        return this.mDataFrom;
    }

    public void setMDataFrom(int mDataFrom) {
        this.mDataFrom = mDataFrom;
    }

}