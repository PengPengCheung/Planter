package com.gdufs.planter.module.frame.model;

import com.gdufs.planter.common.Resource;
import com.google.gson.annotations.SerializedName;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by peng on 2017/4/8.
 */

public class CourseListViewModel {

    @SerializedName(Resource.KEY.KEY_COURSE_INFO_LIST)
    private List<CourseInfoModel> mCourseInfoModelList;

    public CourseListViewModel(){
        mCourseInfoModelList = new LinkedList<>();
    }

    public void addCourseInfo(CourseInfoModel model){
        if(mCourseInfoModelList != null){
            mCourseInfoModelList.add(model);
        }
    }

    public List<CourseInfoModel> getmCourseInfoModelList() {
        return mCourseInfoModelList;
    }

    public void setmCourseInfoModelList(List<CourseInfoModel> mCourseInfoModelList) {
        this.mCourseInfoModelList = mCourseInfoModelList;
    }
}
