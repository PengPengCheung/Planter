package com.gdufs.planter;

import android.app.Application;
import android.app.Service;
import android.os.Vibrator;
import android.util.Log;

import com.gdufs.planter.service.LocationService;
import com.liulishuo.filedownloader.FileDownloader;

import cn.jpush.android.api.JPushInterface;
import cn.jpush.im.android.api.JMessageClient;

/**
 * Created by peng on 2017/3/11.
 */

public class PlanterApplication extends Application {

    public LocationService locationService;
    public Vibrator mVibrator;

    @Override
    public void onCreate() {
        super.onCreate();
        testJMessage();
        initLocationSDK();
        initFileDownloader();
    }

    private void initFileDownloader(){
        FileDownloader.init(getApplicationContext());
    }

    private void initLocationSDK(){
        /***
         * 初始化定位sdk，建议在Application中创建
         */
        locationService = new LocationService(getApplicationContext());
        mVibrator =(Vibrator)getApplicationContext().getSystemService(Service.VIBRATOR_SERVICE);
//        SDKInitializer.initialize(getApplicationContext());
    }

    public void testJMessage(){
        JPushInterface.setDebugMode(true);
        JPushInterface.init(getApplicationContext());
//        JMessageClient.setDebugMode(true);
//        JMessageClient.init(getApplicationContext());
        Log.e("ppp","JPush init");
    }
}
