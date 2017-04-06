package com.gdufs.planter.common;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.gdufs.planter.gen.DaoMaster;

import org.greenrobot.greendao.database.Database;

/**
 * Created by peng on 2017/4/5.
 */

public class DBHelper extends DaoMaster.DevOpenHelper {

    public DBHelper(Context context, String name) {
        super(context, name);
    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    // 默认升级数据库时会把原数据库的数据全部删除，此处做一处封装，开发期间可暂不重写，发布版本需要重写此方法
    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
    }
}
