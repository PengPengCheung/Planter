package com.gdufs.planter.module.attendance.model;

import com.gdufs.planter.common.BaseViewModel;
import com.gdufs.planter.common.Resource;
import com.google.gson.annotations.SerializedName;

public class AttendanceViewModel extends BaseViewModel {

    private static final long serialVersionUID = -7564398009466686520L;

    @SerializedName(Resource.KEY.KEY_ATTENDANCE_TIME)
    private String mAttendanceTime = "time";

    @SerializedName(Resource.KEY.KEY_ATTENDANCE_ATT_COUNT)
    private int mAttendanceCount = 100;

    @SerializedName(Resource.KEY.KEY_ATTENDANCE_ABS_COUNT)
    private int mAbsenceCount = 200;

    @SerializedName(Resource.KEY.KEY_ATTENDANCE_VALID_DURATION)
    private String mAttendanceValidDuration = "duration";

    @SerializedName(Resource.KEY.KEY_ATTENDANCE_BONUS_NUM)
    private int mAttendanceBonusNum = 30;

    @SerializedName(Resource.KEY.KEY_ATTENDANCE_CODE)
    private String mAttendanceCode = "123455";

    @SerializedName(Resource.KEY.KEY_ATTENDANCE_STATUS)
    private int mAttendanceStatus = Resource.ATTENDANCE.ATTENDANCE_STATUS_SUCCESS;

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

}