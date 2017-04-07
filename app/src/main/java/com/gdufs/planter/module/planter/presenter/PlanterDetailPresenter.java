package com.gdufs.planter.module.planter.presenter;

import com.gdufs.planter.common.BaseViewDBModel;
import com.gdufs.planter.common.BaseViewModel;
import com.gdufs.planter.common.ModuleBasePresenter;
import com.gdufs.planter.common.PersistenceManager;
import com.gdufs.planter.common.Resource;

import java.util.List;

/**
 * Created by peng on 2017/4/7.
 */

public class PlanterDetailPresenter extends ModuleBasePresenter {

    private static PlanterDetailPresenter mInstance = null;

    private PlanterDetailPresenter(){}

    public static PlanterDetailPresenter getInstance(){
        if(mInstance == null){
            synchronized (PlanterDetailPresenter.class){
                if(mInstance == null){
                    mInstance = new PlanterDetailPresenter();
                }
            }
        }

        return mInstance;
    }



    public List<BaseViewDBModel> readPlanterDetailByCourseId(String courseId){
        List<BaseViewDBModel> modelList = PersistenceManager.getInstance().findViewDBModelByCustomId(courseId, Resource.MODULE_PLANTER_DETAIL);

        if(modelList != null && modelList.size() == 1){
            return modelList;
        }

        return null;
    }

    @Override
    public void notifyViewUpdate(BaseViewModel model) {

    }
}
