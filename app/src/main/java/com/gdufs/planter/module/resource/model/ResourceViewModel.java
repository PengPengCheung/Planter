package com.gdufs.planter.module.resource.model;

import com.gdufs.planter.common.BaseViewModel;
import com.gdufs.planter.common.Resource;
import com.google.gson.annotations.SerializedName;

/**
 * Created by peng on 2017/4/24.
 */

public class ResourceViewModel extends BaseViewModel {

    @SerializedName(Resource.KEY.KEY_RESOURCE_ID)
    private String mResourceId;

    @SerializedName(Resource.KEY.KEY_RESOURCE_NAME)
    private String mResourceName;

    @SerializedName(Resource.KEY.KEY_RESOURCE_UPLOAD_DATE)
    private String mResourceUploadDate;

    @SerializedName(Resource.KEY.KEY_RESOURCE_LIKE_COUNT)
    private int mLikeCount;

    @SerializedName(Resource.KEY.KEY_RESOURCE_DOWNLOAD_COUNT)
    private int mDownloadCount;

    public String getmResourceId() {
        return mResourceId;
    }

    public void setmResourceId(String mResourceId) {
        this.mResourceId = mResourceId;
    }

    public String getmResourceName() {
        return mResourceName;
    }

    public void setmResourceName(String mResourceName) {
        this.mResourceName = mResourceName;
    }

    public String getmResourceUploadDate() {
        return mResourceUploadDate;
    }

    public void setmResourceUploadDate(String mResourceUploadDate) {
        this.mResourceUploadDate = mResourceUploadDate;
    }

    public int getmLikeCount() {
        return mLikeCount;
    }

    public void setmLikeCount(int mLikeCount) {
        this.mLikeCount = mLikeCount;
    }

    public int getmDownloadCount() {
        return mDownloadCount;
    }

    public void setmDownloadCount(int mDownloadCount) {
        this.mDownloadCount = mDownloadCount;
    }
}
