package com.gdufs.planter.module.summary.presenter;

import com.gdufs.planter.common.BaseViewModel;
import com.gdufs.planter.common.ModuleBasePresenter;
import com.gdufs.planter.common.Resource;
import com.gdufs.planter.utils.NetworkUtil;
import com.gdufs.planter.utils.ResultCallback;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by peng on 2017/3/20.
 */

public class SummaryPresenter extends ModuleBasePresenter {

    private static SummaryPresenter mInstance = null;

    private SummaryPresenter(){
        super();
    }

    public static SummaryPresenter getInstance(){
        if(mInstance == null){
            synchronized (SummaryPresenter.class){
                if(mInstance == null){
                    mInstance = new SummaryPresenter();
                }
            }
        }

        return mInstance;
    }

    public void sendSummary(String summary){
//        Map<String, Object> params = new HashMap<>();
//        params.put(Resource.KEY.KEY_SUMMARY_CONTENT, summary);
//        NetworkUtil.post(Resource.PlanterURL.SUMMARY_SEND_URL, params, new ResultCallback<String>() {
//            @Override
//            public void onSuccess(String response) {
//
//            }
//
//            @Override
//            public void onFailure(Exception e) {
//
//            }
//        });
    }

    @Override
    public void notifyViewUpdate(BaseViewModel model) {
        updateAllViews(model);
    }
}
