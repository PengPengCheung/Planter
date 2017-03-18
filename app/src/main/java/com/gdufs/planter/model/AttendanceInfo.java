package com.gdufs.planter.model;

import com.gdufs.planter.common.Resource;
import com.google.gson.annotations.SerializedName;

/**
 * Created by peng on 2017/3/18.
 */

public class AttendanceInfo {

    private String mAttendanceDate;
    private String mAttendanceTime;

    @SerializedName(Resource.KEY.KEY_ATTENDANCE_STATUS)
    private int mAttendanceStatus = 1000;

    private String mAttendanceCode;
    private String mAttendanceValidTime;

    @SerializedName(Resource.KEY.KEY_ATTENDANCE_BONUS_NUM)
    private int mAttendanceBonusNum;

    public String getmAttendanceDate() {
        return mAttendanceDate;
    }

    public void setmAttendanceDate(String mAttendanceDate) {
        this.mAttendanceDate = mAttendanceDate;
    }

    public String getmAttendanceTime() {
        return mAttendanceTime;
    }

    public void setmAttendanceTime(String mAttendanceTime) {
        this.mAttendanceTime = mAttendanceTime;
    }

    public int getmAttendanceStatus() {
        return mAttendanceStatus;
    }

    public void setmAttendanceStatus(int mAttendanceStatus) {
        this.mAttendanceStatus = mAttendanceStatus;
    }

    public String getmAttendanceCode() {
        return mAttendanceCode;
    }

    public void setmAttendanceCode(String mAttendanceCode) {
        this.mAttendanceCode = mAttendanceCode;
    }

    public String getmAttendanceValidTime() {
        return mAttendanceValidTime;
    }

    public void setmAttendanceValidTime(String mAttendanceValidTime) {
        this.mAttendanceValidTime = mAttendanceValidTime;
    }

    public int getmAttendanceBonusNum() {
        return mAttendanceBonusNum;
    }

    public void setmAttendanceBonusNum(int mAttendanceBonusNum) {
        this.mAttendanceBonusNum = mAttendanceBonusNum;
    }
}
