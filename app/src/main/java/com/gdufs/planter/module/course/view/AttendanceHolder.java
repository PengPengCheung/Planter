package com.gdufs.planter.module.course.view;

import android.view.View;
import android.widget.TextView;

import com.gdufs.planter.R;
import com.gdufs.planter.widget.ItemViewHolder;

/**
 * Created by peng on 2017/3/14.
 */

public class AttendanceHolder extends ItemViewHolder {

    public TextView mTVCourseDate;
    public TextView mTVCourseLimitTime;
    public TextView mTVCourseAttendanceCount;
    public TextView mTVCourseBonusNum;
    public TextView mTVCourseTipsPrefix;


    @Override
    public void findViews() {
        mTVCourseDate = (TextView) itemView.findViewById(R.id.tv_course_item_date);
        mTVCourseLimitTime = (TextView) itemView.findViewById(R.id.tv_course_item_limit_time);
        mTVCourseAttendanceCount = (TextView)itemView.findViewById(R.id.tv_course_item_attendance_count);
        mTVCourseBonusNum = (TextView) itemView.findViewById(R.id.tv_course_item_bonus_num);
        mTVCourseTipsPrefix = (TextView) itemView.findViewById(R.id.tv_course_item_tips_prefix);
    }

    public AttendanceHolder(View itemView) {
        super(itemView);
    }


}
