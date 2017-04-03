package com.gdufs.planter.module.interaction.presenter;

import com.gdufs.planter.common.BaseViewModel;
import com.gdufs.planter.module.push.PushResponseModel;

/**
 * Created by peng on 2017/4/3.
 */

public class InteractionPresenter {

    private static InteractionPresenter mInstance = null;

    private InteractionPresenter(){}

    public static InteractionPresenter getInstance(){
        if(mInstance == null){
            synchronized (InteractionPresenter.class){
                if(mInstance == null){
                    mInstance = new InteractionPresenter();
                }
            }
        }

        return mInstance;
    }


    public void notifyViewUpdate(PushResponseModel model) {

    }
}
