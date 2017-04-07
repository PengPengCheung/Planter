package com.gdufs.planter.common;

import com.gdufs.planter.module.attendance.model.AttendanceViewDBModel;
import com.gdufs.planter.module.attendance.model.AttendanceViewModel;
import com.gdufs.planter.module.planter.model.PlanterDetailViewDBModel;
import com.gdufs.planter.module.planter.model.PlanterViewDBModel;
import com.gdufs.planter.module.planter.model.PlanterViewModel;

/**
 * Created by peng on 2017/4/6.
 */

public class ModelConverter {


    public static AttendanceViewModel convertAttendanceDBModelToViewModel(AttendanceViewDBModel dbModel){
        AttendanceViewModel viewModel = new AttendanceViewModel();
        viewModel.setmDataFrom(dbModel.getmDataFrom());
        viewModel.setmModuleId(dbModel.getmModuleId());
        viewModel.setmStudentId(dbModel.getmStudentId());
        viewModel.setmTeacherId(dbModel.getmTeacherId());
        viewModel.setmCourseId(dbModel.getmCourseId());
        viewModel.setmActionId(dbModel.getmActionId());
        viewModel.setAttendanceId(dbModel.getAttendanceId());
        viewModel.setmAttendanceStatus(dbModel.getmAttendanceStatus());
        viewModel.setmAttendanceBonusNum(dbModel.getmAttendanceBonusNum());
        viewModel.setmAbsenceCount(dbModel.getmAbsenceCount());
        viewModel.setmAttendanceCount(dbModel.getmAttendanceCount());
        viewModel.setmAttendanceCode(dbModel.getmAttendanceCode());
        viewModel.setmAttendanceTime(dbModel.getmAttendanceTime());
        viewModel.setmAttendanceValidDuration(dbModel.getmAttendanceValidDuration());

        return viewModel;
    }

    public static AttendanceViewDBModel convertAttendanceViewModelToDBModel(AttendanceViewModel viewModel){
        AttendanceViewDBModel dbModel = new AttendanceViewDBModel();
        dbModel.setmDataFrom(viewModel.getmDataFrom());
        dbModel.setmModuleId(viewModel.getmModuleId());
        dbModel.setmStudentId(viewModel.getmStudentId());
        dbModel.setmTeacherId(viewModel.getmTeacherId());
        dbModel.setmCourseId(viewModel.getmCourseId());
        dbModel.setmActionId(viewModel.getmActionId());
        dbModel.setAttendanceId(viewModel.getAttendanceId());
        dbModel.setmAttendanceStatus(viewModel.getmAttendanceStatus());
        dbModel.setmAttendanceBonusNum(viewModel.getmAttendanceBonusNum());
        dbModel.setmAbsenceCount(viewModel.getmAbsenceCount());
        dbModel.setmAttendanceCount(viewModel.getmAttendanceCount());
        dbModel.setmAttendanceCode(viewModel.getmAttendanceCode());
        dbModel.setmAttendanceTime(viewModel.getmAttendanceTime());
        dbModel.setmAttendanceValidDuration(viewModel.getmAttendanceValidDuration());

        return dbModel;
    }


    public static PlanterViewModel convertPlanterViewDBModelToViewModel(PlanterViewDBModel dbModel){
        PlanterViewModel viewModel = new PlanterViewModel();

        viewModel.setmDataFrom(dbModel.getmDataFrom());
        viewModel.setmModuleId(dbModel.getmModuleId());
        viewModel.setmStudentId(dbModel.getmStudentId());
        viewModel.setmTeacherId(dbModel.getmTeacherId());
        viewModel.setmCourseId(dbModel.getmCourseId());
        viewModel.setmActionId(dbModel.getmActionId());

        viewModel.setmPlanterStatus(dbModel.getmPlanterStatus());
        viewModel.setmCourseName(dbModel.getmCourseName());
        viewModel.setmCourseTime(dbModel.getmCourseTime());
        viewModel.setmPlanterSunshine(dbModel.getmPlanterSunshine());
        viewModel.setmPlanterSoil(dbModel.getmPlanterSoil());
        viewModel.setmPlanterWater(dbModel.getmPlanterWater());
        viewModel.setmPlanterPercent(dbModel.getmPlanterPercent());

        return viewModel;
    }

    // 转换成DBModel的方法只能用于插入，不能用于更新，因为更新的时候需要校验数据库中已有的数据项的自增id，但是此方法是新建一个DBModel，因此不能用于更新
    public static PlanterViewDBModel convertPlanterViewModelToDBModel(PlanterViewModel viewModel){
        PlanterViewDBModel dbModel = new PlanterViewDBModel();

        dbModel.setmDataFrom(viewModel.getmDataFrom());
        dbModel.setmModuleId(viewModel.getmModuleId());
        dbModel.setmStudentId(viewModel.getmStudentId());
        dbModel.setmTeacherId(viewModel.getmTeacherId());
        dbModel.setmCourseId(viewModel.getmCourseId());
        dbModel.setmActionId(viewModel.getmActionId());

        dbModel.setmPlanterStatus(viewModel.getmPlanterStatus());
        dbModel.setmCourseName(viewModel.getmCourseName());
        dbModel.setmCourseTime(viewModel.getmCourseTime());
        dbModel.setmPlanterSunshine(viewModel.getmPlanterSunshine());
        dbModel.setmPlanterSoil(viewModel.getmPlanterSoil());
        dbModel.setmPlanterWater(viewModel.getmPlanterWater());
        dbModel.setmPlanterPercent(viewModel.getmPlanterPercent());

        return dbModel;
    }

//    public static PlanterDetailViewDBModel convertPlanterDetailViewModelToDBModel(PlanterDetailViewModel viewDBModel){
//
//    }

}
