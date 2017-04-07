package com.gdufs.planter.common;

import com.gdufs.planter.module.planter.model.PlanterViewModel;
import com.gdufs.planter.utils.JsonUtil;
import com.gdufs.planter.utils.LogUtil;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

/**
 * Created by peng on 2017/4/6.
 */

public class ResponseDataConverter {

    private static final String TAG = ResponseDataConverter.class.getSimpleName();

    public static DataResponse<PlanterViewModel> convertToPlanterViewModel(String response){
        try{
            Type classTypeData = new TypeToken<DataResponse<PlanterViewModel>>(){}.getType();
            DataResponse<PlanterViewModel> r = JsonUtil.deserialize(response, classTypeData);
            return r;
        } catch (JsonSyntaxException e){
            e.printStackTrace();
        }

        printErrorMessageAndResponseStr(response);

        return null;
    }

    private static void printErrorMessageAndResponseStr(String response){
        LogUtil.e(TAG, "convert error, the responseStr is: " + response);
    }
}
