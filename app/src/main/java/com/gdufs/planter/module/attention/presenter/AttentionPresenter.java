package com.gdufs.planter.module.attention.presenter;

import com.gdufs.planter.common.BaseViewModel;
import com.gdufs.planter.common.ModuleBasePresenter;
import com.gdufs.planter.common.ModuleBaseView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by peng on 2017/3/20.
 */

public class AttentionPresenter extends ModuleBasePresenter{


    private static AttentionPresenter mInstance = null;

    private AttentionPresenter(){
        super();
    }

    public static AttentionPresenter getInstance(){
        if(mInstance == null) {
            synchronized (AttentionPresenter.class) {
                if(mInstance == null) {
                    mInstance = new AttentionPresenter();
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
