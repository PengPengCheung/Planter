package com.gdufs.planter.utils;

import android.content.Context;
import android.text.TextUtils;

import com.gdufs.planter.common.Resource;
import com.gdufs.planter.module.attendance.presenter.AttendancePresenter;

/**
 * Created by peng on 2017/4/7.
 */

public class CommonUtil {




    public static int getMinimumNum(int x, int y, int z){
        int min = x;
        if(y < min){
            min = y;
        }

        if(z < min){
            min = z;
        }

        return min;
    }

    public static String getCurrentSelectedCourseId(Context context){
        String currentCourseId = PreferenceHelper.getInstance(context).getString(Resource.KEY.KEY_COURSE_ID, "");
        if(currentCourseId != null && !TextUtils.isEmpty(currentCourseId)){
            return currentCourseId;
        }

        return "";
    }

    public static String getCurrentSelectedCourseName(Context context){
        String currentCourseName = PreferenceHelper.getInstance(context).getString(Resource.KEY.KEY_COURSE_NAME, "");
        if(currentCourseName != null && !TextUtils.isEmpty(currentCourseName)){
            return currentCourseName;
        }

        return "";
    }

}
