package com.gdufs.planter.module.attendance.model;

import com.gdufs.planter.common.BaseViewModel;
import com.gdufs.planter.common.Resource;
import com.google.gson.annotations.SerializedName;


public class AttendanceViewModel extends BaseViewModel {

    private static final long serialVersionUID = -7564398009466686520L;

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

    @SerializedName(Resource.KEY.KEY_BONUS_TYPE)
    private int mAttendanceBonusType;


    public int getmAttendanceBonusType() {
        return mAttendanceBonusType;
    }

    public void setmAttendanceBonusType(int mAttendanceBonusType) {
        this.mAttendanceBonusType = mAttendanceBonusType;
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

}