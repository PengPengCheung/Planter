package com.gdufs.planter.module.resource.model;


import com.gdufs.planter.common.BaseViewModel;
import com.gdufs.planter.common.Resource;
import com.google.gson.annotations.SerializedName;

/**
 * Created by peng on 2017/4/14.
 */
public class TeachResource extends BaseViewModel {

    @SerializedName(Resource.KEY.KEY_RESOURCE_NAME)
    private String resourceName;

    @SerializedName(Resource.KEY.KEY_RESOURCE_UPLOAD_DATE)
    private String uploadDate;


    @SerializedName(Resource.KEY.KEY_RESOURCE_DOWNLOAD_COUNT)
    private int downloadCount;

    @SerializedName(Resource.KEY.KEY_RESOURCE_LIKE_COUNT)
    private int likeCount;

    @SerializedName(Resource.KEY.KEY_RESOURCE_DOWNLOAD_URL)
    private String downloadUrl;

    @SerializedName(Resource.KEY.KEY_RESOURCE_ID)
    private String resourceId;

}
