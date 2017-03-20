package com.gdufs.planter.utils;

import com.gdufs.planter.common.DataResponse;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

/**
 * Created by peng on 2017/3/19.
 */

public class ParseUtil<T> {

    public DataResponse<T> parseToObj(String response){
        Type classTypeData = new TypeToken<DataResponse<T>>(){}.getType();
        //解析数据
        DataResponse<T> r = JsonUtil.deserialize(response, classTypeData);
        return r;
    }

}
