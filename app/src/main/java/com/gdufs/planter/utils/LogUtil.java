package com.gdufs.planter.utils;

import android.util.Log;

/**
 * Created by peng on 2017/3/19.
 */

public class LogUtil {

    private final static String DEFAULT_TAG = "Planter";

    public static boolean LOGGABLE = true;

    /**
     * 打印error级别的log
     *
     * @param moduleName moduleType 模块名称
     * @param str 内容
     */
    public static void e(String moduleName, String str) {
        if (LOGGABLE) {
            StackTraceElement ste = new Throwable().getStackTrace()[1];
            Log.e(DEFAULT_TAG, makeLogDetailInfoString(moduleName, str, ste));
        }
    }

    /**
     * 制作打log位置的文件名与文件行号详细信息
     *
     * @param moduleName 模块类型
     * @param str
     * @param ste
     * @return
     */
    private static String makeLogDetailInfoString(String moduleName, String str, StackTraceElement ste) {

        String strLog = "[" + moduleName + "]-" + ste.getFileName() + "("+ ste.getLineNumber() + "): ";
        strLog += str;
        return strLog;
    }
}
