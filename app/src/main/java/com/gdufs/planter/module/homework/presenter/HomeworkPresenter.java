package com.gdufs.planter.module.homework.presenter;

import com.gdufs.planter.common.BaseViewModel;
import com.gdufs.planter.common.ModuleBasePresenter;

/**
 * Created by peng on 2017/3/21.
 */

public class HomeworkPresenter extends ModuleBasePresenter {


    private static HomeworkPresenter mInstance = null;

    private HomeworkPresenter(){}

    public static HomeworkPresenter getInstance(){
        if(mInstance == null){
            synchronized (HomeworkPresenter.class){
                if (mInstance == null){
                    mInstance = new HomeworkPresenter();
                }
            }
        }

        return mInstance;
    }

    @Override
    public void notifyViewUpdate(BaseViewModel model) {
        updateAllViews(model);
    }
}
