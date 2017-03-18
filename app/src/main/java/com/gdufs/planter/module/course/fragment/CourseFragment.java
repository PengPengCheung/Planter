package com.gdufs.planter.module.course.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.gdufs.planter.common.Resource;
import com.gdufs.planter.module.attendance.AttendanceFragment;
import com.gdufs.planter.module.attention.AttentionFragment;
import com.gdufs.planter.module.group.fragment.GroupFragment;
import com.gdufs.planter.module.homework.HomeworkFragment;
import com.gdufs.planter.module.summary.SummaryFragment;
import com.gdufs.planter.widget.UniversalListView;

/**
 * Created by peng on 2017/3/13.
 */

public class CourseFragment extends Fragment {

    UniversalListView mView;

    public static Fragment newInstance(int type) {
        Bundle args = new Bundle();
        args.putInt("type", type);
        Fragment fragment = initFragmentByType(type);
        fragment.setArguments(args);
        return fragment;
    }

    private static Fragment initFragmentByType(int type){
        Fragment fragment = null;
        switch (type) {
            case Resource.MODULE_COURSE_ATTENDANCE:{
                fragment = new AttendanceFragment();
            }
            break;
            case Resource.MODULE_COURSE_HOMEWORK:{
                fragment = new HomeworkFragment();
            }
            break;
            case Resource.MODULE_COURSE_ATTENTION:{
                fragment = new AttentionFragment();
            }
            break;
            case Resource.MODULE_COURSE_SUMMARY:{
                fragment = new SummaryFragment();
            }
            break;
            case Resource.MODULE_COURSE_GROUP:{
                fragment = new GroupFragment();
            }
            break;
            case Resource.MODULE_COURSE_OTHERS:{
                fragment = new CourseFragment();
            }
            break;
        }

        return fragment;
    }

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//
////        mView = new UniversalListView(getActivity(), inflater, container, savedInstanceState);
////        mView.setItemViewListener(new UniversalListView.ItemViewListener() {
////
////            @Override
////            public RecyclerView.ViewHolder createItemViewHolder(Context context) {
////                View view = LayoutInflater.from(context).inflate(R.layout.fragment_course_attendance_item, null);
////                return new AttendanceHolder(view);
////            }
////
////            @Override
////            public void setItemViewContent(RecyclerView.ViewHolder holder) {
////                ((AttendanceHolder) holder).mTVCourseDate.setText("2018年2月29日");
////                ((AttendanceHolder) holder).mTVCourseLimitTime.setText("06:00");
////                String attendanceCount = getResources().getString(R.string.course_attendance_item_attendance_count);
////                String attendanceFormatStr = String.format(attendanceCount, 6, 4);
////                ((AttendanceHolder) holder).mTVCourseAttendanceCount.setText(attendanceFormatStr);
////                String bonusNum = getResources().getString(R.string.course_attendance_item_bonus_num);
////                String bonusStr = String.format(bonusNum, 10);
////                ((AttendanceHolder) holder).mTVCourseBonusNum.setText(bonusStr);
////                ((AttendanceHolder) holder).mTVCourseTipsPrefix.setText("+");
////            }
////        });
////
////        return mView.getUniversalListView();
//    }
}
