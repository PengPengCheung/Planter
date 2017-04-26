package com.gdufs.planter.module.resource.presenter;

import com.gdufs.planter.common.BaseViewModel;
import com.gdufs.planter.common.DataResponse;
import com.gdufs.planter.common.ModuleBasePresenter;
import com.gdufs.planter.common.ModuleBaseView;
import com.gdufs.planter.common.Resource;
import com.gdufs.planter.module.resource.model.ResourceViewModel;
import com.gdufs.planter.module.resource.view.FrameResourceView;
import com.gdufs.planter.utils.JsonUtil;
import com.gdufs.planter.utils.LogUtil;
import com.gdufs.planter.utils.NetworkUtil;
import com.gdufs.planter.utils.ObjectWriter;
import com.gdufs.planter.utils.ResultCallback;
import com.gdufs.planter.utils.TimeUtil;
import com.google.gson.reflect.TypeToken;
import com.liulishuo.filedownloader.BaseDownloadTask;
import com.liulishuo.filedownloader.FileDownloadListener;
import com.liulishuo.filedownloader.FileDownloadSampleListener;
import com.liulishuo.filedownloader.FileDownloader;

import java.io.File;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by peng on 2017/3/27.
 */

public class ResourcePresenter extends ModuleBasePresenter {

    private static final String TAG = ResourcePresenter.class.getSimpleName();

    private static ResourcePresenter mInstance = null;

    private ResourcePresenter(){}

    public static ResourcePresenter getInstance(){
        if(mInstance == null){
            synchronized (ResourcePresenter.class){
                if(mInstance == null){
                    mInstance = new ResourcePresenter();
                }
            }
        }

        return mInstance;
    }

    @Override
    public void notifyViewUpdate(BaseViewModel model) {

    }

    public void requestResourceList(String courseId, String studentId){
        Map<String, Object> params = constructResourceRequestParams(courseId, studentId);
        NetworkUtil.post(Resource.PlanterURL.RESOURCE_LIST_URL, params, new ResultCallback<String>() {
            @Override
            public void onSuccess(String response) {
                LogUtil.e(TAG, "requestResource response: " + response);
                Type classTypeData = new TypeToken<DataResponse<List<ResourceViewModel>>>(){}.getType();
                //解析数据
                DataResponse<List<ResourceViewModel>> r = JsonUtil.deserialize(response, classTypeData);
                if(r != null && r.getData() != null){
                    List<ResourceViewModel> viewModelList = r.getData();
                    if(viewModelList.size() > 0){
                        LogUtil.e(TAG, "resource name: " + viewModelList.get(0).getmResourceName());
                    }
//                    responseIfSuccess(viewModelList);
                    responseAllViewIfSuccess(r);
                }

            }

            @Override
            public void onFailure(Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void responseIfSuccess(List<ResourceViewModel> viewModelList) {

    }

    private Map<String, Object> constructResourceRequestParams(String courseId, String studentId) {
        Map<String, Object> params = new HashMap<>();
        params.put(Resource.KEY.KEY_COURSE_ID, courseId);
        params.put(Resource.KEY.KEY_STUDENT_ID, studentId);
        return params;
    }


//    private void testIon(Context context){
//        Ion.with(context)
//                .load(Resource.PlanterURL.FILE_DOWNLOAD_TEST_URL)
//// have a ProgressBar get updated automatically with the percent
////                .progressBar(progressBar)
//// and a ProgressDialog
////                .progressDialog(progressDialog)
//// can also use a custom callback
//                .progress(new ProgressCallback() {@Override
//                public void onProgress(long downloaded, long total) {
//                    System.out.println("" + downloaded + " / " + total);
//                }
//                })
//                .write(new File(ObjectWriter.FILE_DIRECTORY_TEST))
//                .setCallback(new FutureCallback<File>() {
//                    @Override
//                    public void onCompleted(Exception e, File file) {
//                        LogUtil.e(TAG, "onCompleted");
//                        // download done...
//                        // do stuff with the File or error
//                    }
//                });
//    }
//
//
//    public void downloadFile(Context context){
//        testIon(context);
//    }

    public void downloadFile(String resourceId, String resourceName){


        LogUtil.e(TAG, "downloadFile");
        FileDownloadListener downloadListener = new FileDownloadSampleListener() {
            @Override
            protected void pending(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                LogUtil.e(TAG, "pending soFarBytes: " + soFarBytes + ", totalBytes: " + totalBytes);
            }

            @Override
            protected void progress(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                LogUtil.e(TAG, "progress soFarBytes: " + soFarBytes + ", totalBytes: " + totalBytes);
            }

            @Override
            protected void blockComplete(BaseDownloadTask task) {
                LogUtil.e(TAG, "blockComplete");
            }

            @Override
            protected void completed(BaseDownloadTask task) {
                LogUtil.e(TAG, "download completed.");
                updateAllViewsWhenDownloadFinished(task.getPath());
            }

            @Override
            protected void paused(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                LogUtil.e(TAG, "download paused.");
            }

            @Override
            protected void error(BaseDownloadTask task, Throwable e) {
                e.printStackTrace();
                String errorMsg = e.getMessage();
                updateAllViewsWhenDownloadFail(errorMsg);
            }

            @Override
            protected void warn(BaseDownloadTask task) {
                LogUtil.e(TAG, "download warn");
            }
        };

        LogUtil.e(TAG, "after downloadListener");

        String filePath = getFilePath(resourceId, resourceName);

        FileDownloader.getImpl().create(getDownloadUrl(resourceId)).setPath(filePath).setListener(downloadListener).start();
    }

    private void updateAllViewsWhenDownloadFail(String errorMsg){
        List<ModuleBaseView> viewList = getViewList();
        for (ModuleBaseView view : viewList){
            if(view instanceof FrameResourceView){
                LogUtil.e(TAG, "updateAllViewsWhenDownloadFail errorMsg: " + errorMsg);
                ((FrameResourceView) view).updateWhenDownloadFail(errorMsg);
            }
        }
    }

    private void updateAllViewsWhenDownloadFinished(String filePath){
        List<ModuleBaseView> viewList = getViewList();
        for (ModuleBaseView view : viewList){
            if(view instanceof FrameResourceView){
                LogUtil.e(TAG, "updateAllViewsWhenDownloadFinished filePath: " + filePath);
                ((FrameResourceView) view).updateWhenDownloadSuccess(filePath);
            }
        }
    }

    // ObjectWriter.FILE_DIRECTORY_TEST
    private String getFilePath(String resourceId, String resourceName) {
        Date date = new Date();
        String dateStr = TimeUtil.timeToStr(date, TimeUtil.ENG_PATTERN_YMD_CONTACT);
        String directory = ObjectWriter.ROOT_DIRECTORY + File.separator + "resource" + File.separator + dateStr;
        LogUtil.e(TAG, "dir: " + directory);
        File dir = new File(directory);
        if(!dir.exists()){
            dir.mkdirs();
        }

        String filePath = directory + File.separator + resourceName;
        File file = new File(filePath);
        if(file.exists()){
            file.delete();
        }

        LogUtil.e(TAG, "filePath: " + filePath);

        return filePath;
    }

    private String getDownloadUrl(String id){
        String downloadUrl =  Resource.PlanterURL.FILE_DOWNLOAD_URL + "/" + id;
        LogUtil.e(TAG, "downloadUrl: " + downloadUrl);
        return downloadUrl;
    }

}
