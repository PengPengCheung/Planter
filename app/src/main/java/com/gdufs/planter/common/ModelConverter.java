package com.gdufs.planter.common;

import com.gdufs.planter.module.attendance.model.AttendanceViewDBModel;
import com.gdufs.planter.module.attendance.model.AttendanceViewModel;
import com.gdufs.planter.module.attention.model.AttentionViewDBModel;
import com.gdufs.planter.module.attention.model.AttentionViewModel;
import com.gdufs.planter.module.group.model.GroupPushModel;
import com.gdufs.planter.module.group.model.GroupPushViewModel;
import com.gdufs.planter.module.homework.model.HomeworkViewDBModel;
import com.gdufs.planter.module.homework.model.HomeworkViewModel;
import com.gdufs.planter.module.planter.model.PlanterDetailViewDBModel;
import com.gdufs.planter.module.planter.model.PlanterViewDBModel;
import com.gdufs.planter.module.planter.model.PlanterViewModel;
import com.gdufs.planter.module.summary.model.SummaryViewDBModel;
import com.gdufs.planter.module.summary.model.SummaryViewModel;

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
        viewModel.setmOpenClassId(dbModel.getmOpenClassId());

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
        dbModel.setmOpenClassId(viewModel.getmOpenClassId());

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

    public static AttentionViewModel convertAttentionDBModelToViewModel(AttentionViewDBModel dbModel){
        AttentionViewModel viewModel = new AttentionViewModel();
        viewModel.setmDataFrom(dbModel.getmDataFrom());
        viewModel.setmModuleId(dbModel.getmModuleId());
        viewModel.setmStudentId(dbModel.getmStudentId());
        viewModel.setmTeacherId(dbModel.getmTeacherId());
        viewModel.setmCourseId(dbModel.getmCourseId());
        viewModel.setmActionId(dbModel.getmActionId());

        viewModel.setmAttentionId(dbModel.getmAttentionId());
        viewModel.setmAttentionBonusNum(dbModel.getmAttentionBonusNum());
        viewModel.setmAttentionDuration(dbModel.getmAttentionDuration());
        viewModel.setmAttentionStatus(dbModel.getmAttentionStatus());
        viewModel.setmAttentionFocusCount(dbModel.getmAttentionFocusCount());
        viewModel.setmAttentionLostFocusCount(dbModel.getmAttentionLostFocusCount());
        viewModel.setmAttentionTime(dbModel.getmAttentionTime());
        viewModel.setmAttentionBonusType(dbModel.getmAttentionBonusType());
        viewModel.setmOpenClassId(dbModel.getmOpenClassId());
        viewModel.setmAttentionType(dbModel.getmAttentionType());

        return viewModel;
    }

    public static AttentionViewDBModel convertAttentionViewModelToDBModel(AttentionViewModel viewModel){
        AttentionViewDBModel dbModel = new AttentionViewDBModel();
        dbModel.setmDataFrom(viewModel.getmDataFrom());
        dbModel.setmModuleId(viewModel.getmModuleId());
        dbModel.setmStudentId(viewModel.getmStudentId());
        dbModel.setmTeacherId(viewModel.getmTeacherId());
        dbModel.setmCourseId(viewModel.getmCourseId());
        dbModel.setmActionId(viewModel.getmActionId());

        dbModel.setmAttentionId(viewModel.getmAttentionId());
        dbModel.setmAttentionBonusNum(viewModel.getmAttentionBonusNum());
        dbModel.setmAttentionDuration(viewModel.getmAttentionDuration());
        dbModel.setmAttentionStatus(viewModel.getmAttentionStatus());
        dbModel.setmAttentionFocusCount(viewModel.getmAttentionFocusCount());
        dbModel.setmAttentionLostFocusCount(viewModel.getmAttentionLostFocusCount());
        dbModel.setmAttentionTime(viewModel.getmAttentionTime());
        dbModel.setmAttentionBonusType(viewModel.getmAttentionBonusType());
        dbModel.setmOpenClassId(viewModel.getmOpenClassId());
        dbModel.setmAttentionType(viewModel.getmAttentionType());

        return dbModel;
    }

    public static SummaryViewDBModel convertSummaryViewModelToDBModel(SummaryViewModel viewModel){
        SummaryViewDBModel dbModel = new SummaryViewDBModel();
        dbModel.setmDataFrom(viewModel.getmDataFrom());
        dbModel.setmModuleId(viewModel.getmModuleId());
        dbModel.setmStudentId(viewModel.getmStudentId());
        dbModel.setmTeacherId(viewModel.getmTeacherId());
        dbModel.setmCourseId(viewModel.getmCourseId());
        dbModel.setmActionId(viewModel.getmActionId());

        dbModel.setmSummaryId(viewModel.getmSummaryId());
        dbModel.setmSummaryBonusNum(viewModel.getmSummaryBonusNum());
        dbModel.setmSummaryContent(viewModel.getmSummaryContent());
        dbModel.setmSummaryRequestTime(viewModel.getmSummaryRequestTime());
        dbModel.setmSummaryStatus(viewModel.getmSummaryStatus());

        return dbModel;
    }

    public static SummaryViewModel convertSummaryViewDBModelToViewModel(SummaryViewDBModel dbModel){
        SummaryViewModel viewModel = new SummaryViewModel();
        viewModel.setmDataFrom(dbModel.getmDataFrom());
        viewModel.setmModuleId(dbModel.getmModuleId());
        viewModel.setmStudentId(dbModel.getmStudentId());
        viewModel.setmTeacherId(dbModel.getmTeacherId());
        viewModel.setmCourseId(dbModel.getmCourseId());
        viewModel.setmActionId(dbModel.getmActionId());

        viewModel.setmSummaryId(dbModel.getmSummaryId());
        viewModel.setmSummaryBonusNum(dbModel.getmSummaryBonusNum());
        viewModel.setmSummaryContent(dbModel.getmSummaryContent());
        viewModel.setmSummaryRequestTime(dbModel.getmSummaryRequestTime());
        viewModel.setmSummaryStatus(dbModel.getmSummaryStatus());

        return viewModel;
    }

    public static HomeworkViewDBModel convertHomeworkViewModelToDBModel(HomeworkViewModel viewModel){
        HomeworkViewDBModel dbModel = new HomeworkViewDBModel();
        dbModel.setmDataFrom(viewModel.getmDataFrom());
        dbModel.setmModuleId(viewModel.getmModuleId());
        dbModel.setmStudentId(viewModel.getmStudentId());
        dbModel.setmTeacherId(viewModel.getmTeacherId());
        dbModel.setmCourseId(viewModel.getmCourseId());
        dbModel.setmActionId(viewModel.getmActionId());

        dbModel.setmHomeworkId(viewModel.getmHomeworkId());
        dbModel.setmHomeworkContent(viewModel.getmHomeworkContent());
        dbModel.setmHomeworkBonusNum(viewModel.getmHomeworkBonusNum());
        dbModel.setmHomeworkItemCurrentTime(viewModel.getmHomeworkItemCurrentTime());
        dbModel.setmHomeworkPublishTime(viewModel.getmHomeworkPublishTime());
        dbModel.setmHomeworkRank(viewModel.getmHomeworkRank());
        dbModel.setmHomeworkScore(viewModel.getmHomeworkScore());
        dbModel.setmHomeworkSubmitDDL(viewModel.getmHomeworkSubmitDDL());
        dbModel.setmHomeworkTitle(viewModel.getmHomeworkTitle());
        dbModel.setmHomeworkStatus(viewModel.getmHomeworkStatus());

        return dbModel;
    }


    public static HomeworkViewModel convertHomeworkDBModelToViewModel(HomeworkViewDBModel dbModel){
        HomeworkViewModel viewModel = new HomeworkViewModel();
        viewModel.setmDataFrom(dbModel.getmDataFrom());
        viewModel.setmModuleId(dbModel.getmModuleId());
        viewModel.setmStudentId(dbModel.getmStudentId());
        viewModel.setmTeacherId(dbModel.getmTeacherId());
        viewModel.setmCourseId(dbModel.getmCourseId());
        viewModel.setmActionId(dbModel.getmActionId());

        viewModel.setmHomeworkId(dbModel.getmHomeworkId());
        viewModel.setmHomeworkContent(dbModel.getmHomeworkContent());
        viewModel.setmHomeworkBonusNum(dbModel.getmHomeworkBonusNum());
        viewModel.setmHomeworkItemCurrentTime(dbModel.getmHomeworkItemCurrentTime());
        viewModel.setmHomeworkPublishTime(dbModel.getmHomeworkPublishTime());
        viewModel.setmHomeworkRank(dbModel.getmHomeworkRank());
        viewModel.setmHomeworkScore(dbModel.getmHomeworkScore());
        viewModel.setmHomeworkSubmitDDL(dbModel.getmHomeworkSubmitDDL());
        viewModel.setmHomeworkTitle(dbModel.getmHomeworkTitle());
        viewModel.setmHomeworkStatus(dbModel.getmHomeworkStatus());

        return viewModel;
    }


    public static GroupPushViewModel convertToGroupViewModel(GroupPushModel model){
        GroupPushViewModel viewModel = new GroupPushViewModel();
        viewModel.setmCourseId(model.getmCourseId());
        viewModel.setmModuleId(model.getmModuleId());
        viewModel.setmPushType(model.getmPushType());
        viewModel.setmGroupOpenTime(model.getmGroupOpenTime());
        viewModel.setmGroupLimit(model.getmGroupLimit());
        viewModel.setmTeacherGroupOpenId(model.getmTeacherGroupOpenId());

        return viewModel;
    }

    public static GroupPushModel convertToGroupDBModel(GroupPushViewModel model){
        GroupPushModel viewModel = new GroupPushModel();
        viewModel.setmCourseId(model.getmCourseId());
        viewModel.setmModuleId(model.getmModuleId());
        viewModel.setmPushType(model.getmPushType());
        viewModel.setmGroupOpenTime(model.getmGroupOpenTime());
        viewModel.setmGroupLimit(model.getmGroupLimit());
        viewModel.setmTeacherGroupOpenId(model.getmTeacherGroupOpenId());

        return viewModel;
    }



}
