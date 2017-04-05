package com.gdufs.planter.module.interaction.model;

import com.gdufs.planter.common.BaseViewModel;
import com.gdufs.planter.module.attendance.model.AttendanceViewModel;
import com.gdufs.planter.module.attention.model.AttentionViewModel;

/**
 * Created by peng on 2017/4/3.
 */

public class InteractionViewModel {

    private AttendanceViewModel attendanceViewModel;

    private AttentionViewModel attentionViewModel;

    public AttendanceViewModel getAttendanceViewModel() {
        return attendanceViewModel;
    }

    public void setAttendanceViewModel(AttendanceViewModel attendanceViewModel) {
        this.attendanceViewModel = attendanceViewModel;
    }

    public AttentionViewModel getAttentionViewModel() {
        return attentionViewModel;
    }

    public void setAttentionViewModel(AttentionViewModel attentionViewModel) {
        this.attentionViewModel = attentionViewModel;
    }
}
