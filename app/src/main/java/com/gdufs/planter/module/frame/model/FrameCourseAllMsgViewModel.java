package com.gdufs.planter.module.frame.model;

import com.gdufs.planter.common.BaseViewModel;
import com.gdufs.planter.common.Resource;
import com.gdufs.planter.module.attendance.model.AttendanceViewModel;
import com.gdufs.planter.module.attention.model.AttentionViewModel;
import com.gdufs.planter.module.homework.mode.HomeworkViewModel;
import com.gdufs.planter.module.summary.model.SummaryViewModel;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by peng on 2017/3/26.
 */

public class FrameCourseAllMsgViewModel extends BaseViewModel {

    @SerializedName(Resource.MODULE_COURSE_ATTENDANCE_NAME)
    private List<AttendanceViewModel> mAttendanceList;

    @SerializedName(Resource.MODULE_COURSE_ATTENTION_NAME)
    private List<AttentionViewModel> mAttentionList;

    @SerializedName(Resource.MODULE_COURSE_SUMMARY_NAME)
    private List<SummaryViewModel> mSummaryList;

    @SerializedName(Resource.MODULE_COURSE_HOMEWORK_NAME)
    private List<HomeworkViewModel> mHomeworkList;

    public List<AttendanceViewModel> getmAttendanceList() {
        return mAttendanceList;
    }

    public void setmAttendanceList(List<AttendanceViewModel> mAttendanceList) {
        this.mAttendanceList = mAttendanceList;
    }

    public List<AttentionViewModel> getmAttentionList() {
        return mAttentionList;
    }

    public void setmAttentionList(List<AttentionViewModel> mAttentionList) {
        this.mAttentionList = mAttentionList;
    }

    public List<SummaryViewModel> getmSummaryList() {
        return mSummaryList;
    }

    public void setmSummaryList(List<SummaryViewModel> mSummaryList) {
        this.mSummaryList = mSummaryList;
    }

    public List<HomeworkViewModel> getmHomeworkList() {
        return mHomeworkList;
    }

    public void setmHomeworkList(List<HomeworkViewModel> mHomeworkList) {
        this.mHomeworkList = mHomeworkList;
    }
}
