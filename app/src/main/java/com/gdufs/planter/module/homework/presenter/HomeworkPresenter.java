package com.gdufs.planter.module.homework.presenter;

import android.text.TextUtils;

import com.gdufs.planter.common.BaseViewModel;
import com.gdufs.planter.common.ModuleBasePresenter;
import com.gdufs.planter.common.PersistenceManager;
import com.gdufs.planter.common.Resource;

import java.util.LinkedList;
import java.util.List;

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

    @Override
    public List<BaseViewModel> readAllViewModelToList(String courseId) {
        if(courseId != null && !TextUtils.isEmpty(courseId)){
            return PersistenceManager.getInstance().findViewModelByCustomId(courseId, Resource.MODULE_COURSE_HOMEWORK);
        }

        return new LinkedList<>();
    }
}
