package com.gdufs.planter.common;

import com.gdufs.planter.module.attendance.model.AttendanceViewModel;

/**
 * Created by peng on 2017/3/18.
 */

public interface ModuleBaseView extends BaseView {
//    void onReceiveAttendanceStatus(int status);
    void update(BaseViewModel model);
}
