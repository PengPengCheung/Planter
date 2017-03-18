package com.gdufs.planter.model;

import java.util.List;
import java.util.Map;

/**
 * Created by peng on 2017/3/18.
 */

public class Course {
    private String mCourseName;
    private List<Map<String, String>> mCourseInfo;

    public String getmCourseName() {
        return mCourseName;
    }

    public void setmCourseName(String mCourseName) {
        this.mCourseName = mCourseName;
    }

    public List<Map<String, String>> getmCourseInfo() {
        return mCourseInfo;
    }

    public void setmCourseInfo(List<Map<String, String>> mCourseInfo) {
        this.mCourseInfo = mCourseInfo;
    }
}
