package com.gdufs.planter.module.attendance.view;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.gdufs.planter.ClassInteractionActivity;
import com.gdufs.planter.R;
import com.gdufs.planter.common.Resource;
import com.gdufs.planter.module.attendance.model.AttendanceViewModel;
import com.gdufs.planter.utils.NetworkUtil;
import com.gdufs.planter.utils.ResultCallback;
import com.gdufs.planter.widget.ItemViewHolder;

import java.util.HashMap;
import java.util.Map;

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

    public void setViews(AttendanceViewModel model){
        mTVCourseDate.setText(model.getmAttendanceTime());
        mTVCourseLimitTime.setText(model.getmAttendanceValidDuration());
        String attendanceCount = mContext.getResources().getString(R.string.course_attendance_item_attendance_count);
        String attendanceFormatStr = String.format(attendanceCount, model.getmAttendanceCount(), model.getmAbsenceCount());
        mTVCourseAttendanceCount.setText(attendanceFormatStr);
        String bonusNum = mContext.getResources().getString(R.string.course_attendance_item_bonus_num);
        int bonus = model.getmAttendanceBonusNum();
        if(bonus > 0) {
            String bonusStr = String.format(bonusNum, bonus);
            mTVCourseBonusNum.setText(bonusStr);
        } else {
            String bonusStr = String.format(bonusNum, -bonus);
            mTVCourseBonusNum.setText(bonusStr);
        }

        if(model.getmAttendanceStatus() == Resource.ATTENDANCE.ATTENDANCE_STATUS_SUCCESS) {
            mTVCourseTipsPrefix.setText("+");
        } else if(model.getmAttendanceStatus() == Resource.ATTENDANCE.ATTENDANCE_STATUS_DEFAULT) {
            mTVCourseTipsPrefix.setText("可获");
        } else if(model.getmAttendanceStatus() == Resource.ATTENDANCE.ATTENDANCE_STATUS_FAIL){
            mTVCourseTipsPrefix.setText("-");
        }

        mTVCourseAttendanceEnterClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ClassInteractionActivity.class);
                mContext.startActivity(intent);

            }
        });

//        mTVCourseAttendanceEnterClass.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(mContext, "view test2", Toast.LENGTH_SHORT).show();
//                Map<String, Object> params = new HashMap<>();
//                params.put("client", "hello");
//                params.put("server", "hi");
//                NetworkUtil.post(Resource.PlanterURL.JSON_TEST_URL, params, new ResultCallback<String>() {
//
//                    @Override
//                    public void onSuccess(String response) {
//                        Log.e("ppp", "response: " + response);
//                        Toast.makeText(mContext, "success", Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onFailure(Exception e) {
//                        Log.e("ppp", "fail: " );
//                        e.printStackTrace();
//                        Toast.makeText(mContext, "fail", Toast.LENGTH_SHORT).show();
//                    }
//                });
//            }
//        });
    }
}
