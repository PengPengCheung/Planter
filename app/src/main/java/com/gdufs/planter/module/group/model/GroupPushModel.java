package com.gdufs.planter.module.group.model;

import com.gdufs.planter.common.Resource;
import com.gdufs.planter.utils.LogUtil;
import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.util.LinkedList;
import java.util.List;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by peng on 2017/4/25.
 */

@Entity
public class GroupPushModel {

    @Id
    private Long id;

    @SerializedName(Resource.KEY.KEY_TEACHER_OPEN_GROUP_ID)
    private String mTeacherGroupOpenId;

    @SerializedName(Resource.KEY.KEY_GROUP_PUSH_TYPE)
    private int mPushType;

    @SerializedName(Resource.KEY.KEY_COURSE_ID)
    private String mCourseId;

    @SerializedName(Resource.KEY.KEY_MODULE_ID)
    private int mModuleId;

    @SerializedName(Resource.KEY.KEY_GROUP_OPEN_TIME)
    private String mGroupOpenTime;

    @SerializedName(Resource.KEY.KEY_GROUP_LIMIT)
    private String mGroupLimit;

    @Generated(hash = 1716852431)
    public GroupPushModel(Long id, String mTeacherGroupOpenId, int mPushType,
            String mCourseId, int mModuleId, String mGroupOpenTime,
            String mGroupLimit) {
        this.id = id;
        this.mTeacherGroupOpenId = mTeacherGroupOpenId;
        this.mPushType = mPushType;
        this.mCourseId = mCourseId;
        this.mModuleId = mModuleId;
        this.mGroupOpenTime = mGroupOpenTime;
        this.mGroupLimit = mGroupLimit;
    }

    @Generated(hash = 662374456)
    public GroupPushModel() {
    }

    public String getmTeacherGroupOpenId() {
        return mTeacherGroupOpenId;
    }

    public void setmTeacherGroupOpenId(String mTeacherGroupOpenId) {
        this.mTeacherGroupOpenId = mTeacherGroupOpenId;
    }

    public int getmModuleId() {
        return mModuleId;
    }

    public void setmModuleId(int mModuleId) {
        this.mModuleId = mModuleId;
    }

    public int getmPushType() {
        return mPushType;
    }

    public void setmPushType(int mPushType) {
        this.mPushType = mPushType;
    }

    public String getmCourseId() {
        return mCourseId;
    }

    public void setmCourseId(String mCourseId) {
        this.mCourseId = mCourseId;
    }

    public String getmGroupOpenTime() {
        return mGroupOpenTime;
    }

    public void setmGroupOpenTime(String mGroupOpenTime) {
        this.mGroupOpenTime = mGroupOpenTime;
    }

    public String getmGroupLimit() {
        return mGroupLimit;
    }

    public void setmGroupLimit(String mGroupLimit) {
        this.mGroupLimit = mGroupLimit;
    }

    public List<Integer> transferGroupLimitToList(String groupLimit){
        String[] limits = groupLimit.split(",");
        List<Integer> limitList = new LinkedList<>();
        for(int i=0;i<limits.length;i++){
            String minStr = limits[0];
            String maxStr = limits[1];
            int min = Integer.parseInt(minStr);
            int max = Integer.parseInt(maxStr);
            LogUtil.e("GroupPushModel", "limit: " + min + ", " + max);
            limitList.add(min);
            limitList.add(max);
        }

        return limitList;

    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMCourseId() {
        return this.mCourseId;
    }

    public void setMCourseId(String mCourseId) {
        this.mCourseId = mCourseId;
    }

    public String getMGroupOpenTime() {
        return this.mGroupOpenTime;
    }

    public void setMGroupOpenTime(String mGroupOpenTime) {
        this.mGroupOpenTime = mGroupOpenTime;
    }

    public String getMGroupLimit() {
        return this.mGroupLimit;
    }

    public void setMGroupLimit(String mGroupLimit) {
        this.mGroupLimit = mGroupLimit;
    }

    public int getMPushType() {
        return this.mPushType;
    }

    public void setMPushType(int mPushType) {
        this.mPushType = mPushType;
    }

    public int getMModuleId() {
        return this.mModuleId;
    }

    public void setMModuleId(int mModuleId) {
        this.mModuleId = mModuleId;
    }

    public String getMTeacherGroupOpenId() {
        return this.mTeacherGroupOpenId;
    }

    public void setMTeacherGroupOpenId(String mTeacherGroupOpenId) {
        this.mTeacherGroupOpenId = mTeacherGroupOpenId;
    }
}
