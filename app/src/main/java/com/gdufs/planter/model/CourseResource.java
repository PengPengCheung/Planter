package com.gdufs.planter.model;

/**
 * Created by peng on 2017/3/18.
 */

public class CourseResource {

    private String mResourceId;
    private String mResourceUploadTime;
    private String mResourceUrl;
    private String mResourceName;
    private int mResourceDownloadCount;
    private int mResourceLikeCount;

    public String getmResourceId() {
        return mResourceId;
    }

    public void setmResourceId(String mResourceId) {
        this.mResourceId = mResourceId;
    }

    public String getmResourceUploadTime() {
        return mResourceUploadTime;
    }

    public void setmResourceUploadTime(String mResourceUploadTime) {
        this.mResourceUploadTime = mResourceUploadTime;
    }

    public String getmResourceUrl() {
        return mResourceUrl;
    }

    public void setmResourceUrl(String mResourceUrl) {
        this.mResourceUrl = mResourceUrl;
    }

    public String getmResourceName() {
        return mResourceName;
    }

    public void setmResourceName(String mResourceName) {
        this.mResourceName = mResourceName;
    }

    public int getmResourceDownloadCount() {
        return mResourceDownloadCount;
    }

    public void setmResourceDownloadCount(int mResourceDownloadCount) {
        this.mResourceDownloadCount = mResourceDownloadCount;
    }

    public int getmResourceLikeCount() {
        return mResourceLikeCount;
    }

    public void setmResourceLikeCount(int mResourceLikeCount) {
        this.mResourceLikeCount = mResourceLikeCount;
    }
}
