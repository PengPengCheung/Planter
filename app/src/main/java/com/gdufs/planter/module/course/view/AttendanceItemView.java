package com.gdufs.planter.module.course.view;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.gdufs.planter.R;
import com.gdufs.planter.widget.ItemViewHolder;

/**
 * Created by peng on 2017/3/15.
 */

public class AttendanceItemView extends ItemViewHolder{

    public TextView mTVCourseDate;
    public TextView mTVCourseLimitTime;
    public TextView mTVCourseAttendanceCount;
    public TextView mTVCourseBonusNum;
    public TextView mTVCourseTipsPrefix;
    public TextView mTVCourseAttendanceEnterClass;

    private Context mContext;



    public AttendanceItemView(View itemView, Context context){
        super(itemView);
        mContext = context;
    }

    @Override
    public void findViews(View itemView){
        mTVCourseDate = (TextView) itemView.findViewById(R.id.tv_course_item_date);
        mTVCourseLimitTime = (TextView) itemView.findViewById(R.id.tv_course_item_limit_time);
        mTVCourseAttendanceCount = (TextView)itemView.findViewById(R.id.tv_course_item_attendance_count);
        mTVCourseBonusNum = (TextView) itemView.findViewById(R.id.tv_course_item_bonus_num);
        mTVCourseTipsPrefix = (TextView) itemView.findViewById(R.id.tv_course_item_tips_prefix);
        mTVCourseAttendanceEnterClass = (TextView) itemView.findViewById(R.id.tv_course_item_enter_class);
    }

    public void setViews(){
        mTVCourseDate.setText("2018年2月29日");
        mTVCourseLimitTime.setText("06:00");
        String attendanceCount = mContext.getResources().getString(R.string.course_attendance_item_attendance_count);
        String attendanceFormatStr = String.format(attendanceCount, 6, 4);
        mTVCourseAttendanceCount.setText(attendanceFormatStr);
        String bonusNum = mContext.getResources().getString(R.string.course_attendance_item_bonus_num);
        String bonusStr = String.format(bonusNum, 10);
        mTVCourseBonusNum.setText(bonusStr);
        mTVCourseTipsPrefix.setText("+");

        mTVCourseAttendanceEnterClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "view test2", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
