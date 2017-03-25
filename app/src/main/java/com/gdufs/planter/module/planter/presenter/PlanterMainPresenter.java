package com.gdufs.planter.module.planter.presenter;

import com.gdufs.planter.common.BaseViewModel;
import com.gdufs.planter.common.ModuleBasePresenter;

/**
 * Created by peng on 2017/3/25.
 */

public class PlanterMainPresenter extends ModuleBasePresenter {

    private static PlanterMainPresenter mInstance = null;

    private PlanterMainPresenter(){}

    public static PlanterMainPresenter getInstance(){
        if(mInstance == null) {
            synchronized (PlanterMainPresenter.class){
                if(mInstance == null){
                    mInstance = new PlanterMainPresenter();
                }
            }
        }

        return mInstance;
    }


    @Override
    public void notifyViewUpdate(BaseViewModel model) {

    }
}
