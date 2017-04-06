package com.gdufs.planter;

import android.app.Application;
import android.app.Service;
import android.database.sqlite.SQLiteDatabase;
import android.os.Vibrator;
import android.util.Log;

import com.gdufs.planter.common.DBHelper;
import com.gdufs.planter.common.Resource;
import com.gdufs.planter.gen.DaoMaster;
import com.gdufs.planter.gen.DaoSession;
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


    private DaoMaster.DevOpenHelper mHelper;
    private SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;
    public static PlanterApplication instances;

    @Override
    public void onCreate() {
        super.onCreate();
        instances = this;
        testJMessage();
        initLocationSDK();
        initFileDownloader();
        setDatabase();
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

    public static PlanterApplication getInstances() {
        return instances;
    }

    /**
     * 设置greenDao
     */
    private void setDatabase() {
        // 通过 DaoMaster 的内部类 DevOpenHelper，你可以得到一个便利的 SQLiteOpenHelper 对象。
        // 可能你已经注意到了，你并不需要去编写「CREATE TABLE」这样的 SQL 语句，因为 greenDAO 已经帮你做了。
        // 注意：默认的 DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
        // 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。
        mHelper = new DBHelper(this, Resource.DBInfo.SCHEMA_NAME, null);
        db = mHelper.getWritableDatabase();
        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    public SQLiteDatabase getDb() {
        return db;
    }
}
