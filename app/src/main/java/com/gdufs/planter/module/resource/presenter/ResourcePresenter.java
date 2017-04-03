package com.gdufs.planter.module.resource.presenter;

import android.content.Context;

import com.gdufs.planter.common.BaseViewModel;
import com.gdufs.planter.common.ModuleBasePresenter;
import com.gdufs.planter.common.Resource;
import com.gdufs.planter.utils.LogUtil;
import com.gdufs.planter.utils.ObjectWriter;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.ProgressCallback;
import com.liulishuo.filedownloader.BaseDownloadTask;
import com.liulishuo.filedownloader.FileDownloadListener;
import com.liulishuo.filedownloader.FileDownloadSampleListener;
import com.liulishuo.filedownloader.FileDownloader;

import java.io.File;

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


    private void testIon(Context context){
        Ion.with(context)
                .load(Resource.PlanterURL.FILE_DOWNLOAD_TEST_URL)
// have a ProgressBar get updated automatically with the percent
//                .progressBar(progressBar)
// and a ProgressDialog
//                .progressDialog(progressDialog)
// can also use a custom callback
                .progress(new ProgressCallback() {@Override
                public void onProgress(long downloaded, long total) {
                    System.out.println("" + downloaded + " / " + total);
                }
                })
                .write(new File(ObjectWriter.FILE_DIRECTORY_TEST))
                .setCallback(new FutureCallback<File>() {
                    @Override
                    public void onCompleted(Exception e, File file) {
                        LogUtil.e(TAG, "onCompleted");
                        // download done...
                        // do stuff with the File or error
                    }
                });
    }


    public void downloadFile(Context context){
        testIon(context);
    }

    public void downloadFile(){


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
            }

            @Override
            protected void paused(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                LogUtil.e(TAG, "download paused.");
            }

            @Override
            protected void error(BaseDownloadTask task, Throwable e) {
                e.printStackTrace();
            }

            @Override
            protected void warn(BaseDownloadTask task) {
                LogUtil.e(TAG, "download warn");
            }
        };

        LogUtil.e(TAG, "after downloadListener");

        FileDownloader.getImpl().create(Resource.PlanterURL.FILE_DOWNLOAD_URL).setPath(ObjectWriter.FILE_DIRECTORY_TEST).setListener(downloadListener).start();
    }

}
