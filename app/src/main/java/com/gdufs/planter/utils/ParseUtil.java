package com.gdufs.planter.utils;

import android.content.Context;

import com.gdufs.planter.common.DataResponse;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

/**
 * Created by peng on 2017/3/19.
 */

public class ParseUtil<T> {

    public static final int DIGIT = 0;
    public static final int STRING = 1;

    public DataResponse<T> parseToObj(String response){
        Type classTypeData = new TypeToken<DataResponse<T>>(){}.getType();
        //解析数据
        DataResponse<T> r = JsonUtil.deserialize(response, classTypeData);
        return r;
    }

//    public static String format(Context context, int strResId, int type, String... str){
//        String notFormatStr =  context.getResources().getString(strResId);
//        String formatStr = null;
//        switch (type) {
//            case DIGIT:{
//                formatStr = String.format(notFormatStr, str);
//            }
//            break;
//            case STRING:{
//
//            }
//            break;
//        }
//
//        return formatStr;
//    }

}
