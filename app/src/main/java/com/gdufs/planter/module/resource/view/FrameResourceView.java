package com.gdufs.planter.module.resource.view;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.gdufs.planter.R;
import com.gdufs.planter.common.BaseViewModel;
import com.gdufs.planter.common.DataResponse;
import com.gdufs.planter.common.ModuleBaseView;
import com.gdufs.planter.common.Resource;
import com.gdufs.planter.module.resource.model.ResourceViewModel;
import com.gdufs.planter.module.resource.presenter.ResourcePresenter;
import com.gdufs.planter.utils.LogUtil;
import com.gdufs.planter.utils.PreferenceHelper;
import com.gdufs.planter.widget.LoadingDialog;
import com.gdufs.planter.widget.UniversalListView;

import java.util.List;

/**
 * Created by peng on 2017/3/27.
 */

public class FrameResourceView implements ModuleBaseView {

    private String TAG = FrameResourceView.class.getSimpleName();

    private UniversalListView mListView;
    private Activity mActivity;
    private LoadingDialog mLoadingDialog;

    public FrameResourceView(Activity activity, View view){
        mActivity = activity;
        initParams();
        initViews(view);
        setListeners();
        requestResourceData();
    }

    private void requestResourceData(){
        showLoadingDialog();
        String courseId = PreferenceHelper.getInstance(mActivity).getString(Resource.KEY.KEY_COURSE_ID, "");
        String studentId = "";
        ResourcePresenter.getInstance().requestResourceList(courseId, studentId);
    }

    private void initParams(){
        ResourcePresenter.getInstance().registerView(this);

    }

    private void setListeners(){
        mListView.setItemViewListener(new UniversalListView.ItemViewListener() {
            @Override
            public RecyclerView.ViewHolder createItemViewHolder(Context context) {
                View view = LayoutInflater.from(context).inflate(R.layout.fragment_resource_item, null);
                FrameResourceItemView itemView = new FrameResourceItemView(context, view);
                setItemViewListeners(itemView);
                return itemView;
            }

            @Override
            public void setItemViewContent(RecyclerView.ViewHolder holder, int pos) {
                List<ResourceViewModel> modelList = mListView.getAdapter().getData();
                if(modelList != null){
                    int size = modelList.size();
                    if(pos < size){
                        ((FrameResourceItemView) holder).setViews(modelList.get(pos));
                    }
                }
            }
        });
    }

    private void setItemViewListeners(FrameResourceItemView itemView){
        itemView.setOnDownloadListener(new FrameResourceItemView.OnDownloadListener() {
            @Override
            public void download(String id, String fileName) {
                showLoadingDialog();
                ResourcePresenter.getInstance().downloadFile(mActivity, id, fileName);
            }
        });
    }

    private void initViews(View view){
        mListView = new UniversalListView(mActivity, view);
        mLoadingDialog = new LoadingDialog(mActivity);

        mListView.setRefreshEnabled(true);
        mListView.setRefreshListener(new UniversalListView.OnUniversalListViewRefreshListener() {
            @Override
            public void refresh() {
                mListView.showProgress(false);
                requestResourceData();
            }
        });
    }

    private void showLoadingDialog(){
        if(mLoadingDialog != null && !mLoadingDialog.isShowing()){
            mLoadingDialog.show();
        }
    }

    private void dismissLoadingDialog(){
        if(mLoadingDialog != null && mLoadingDialog.isShowing()){
            mLoadingDialog.dismiss();
        }
    }

    public View getUniversalListView(){
        return mListView.getUniversalListView();
    }

//    private List<> getResourceDataList(){
//
//    }

    public void showProgressBar(){

    }

    public void updateWhenDownloadSuccess(String filePath){
        dismissLoadingDialog();
//        PreferenceHelper.getInstance(mActivity).putBoolean(filePath, true);
        requestResourceData();
        String toastTips = "文件已保存至 " + filePath;
        Toast.makeText(mActivity, toastTips, Toast.LENGTH_LONG).show();
    }

    public void updateWhenDownloadFail(String errorMsg){
        dismissLoadingDialog();
        Toast.makeText(mActivity, errorMsg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void update(BaseViewModel model) {

    }

    @Override
    public void onResponseSuccess(DataResponse response) {
        LogUtil.e(TAG, "enter onResponseSuccess");
        dismissLoadingDialog();
        if(response != null && response.getData() != null){
            List<ResourceViewModel> viewModelList = (List<ResourceViewModel>) response.getData();
            if(mListView != null){
                mListView.getAdapter().clearData();
                mListView.getAdapter().addData(viewModelList);
            }
        }
    }

    @Override
    public void onResponseFailure(Exception e) {

    }
}
