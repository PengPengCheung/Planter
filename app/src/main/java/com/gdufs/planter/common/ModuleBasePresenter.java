package com.gdufs.planter.common;

import com.gdufs.planter.module.attendance.model.AttendanceViewModel;
import com.gdufs.planter.utils.LogUtil;
import com.gdufs.planter.utils.ObjectWriter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by peng on 2017/3/20.
 */

public abstract class ModuleBasePresenter {

    private static final String TAG = ModuleBasePresenter.class.getSimpleName();

    private List<ModuleBaseView> mViewList;

    public ModuleBasePresenter(){
        mViewList = new ArrayList<>();
    }

    public void registerView(ModuleBaseView view){
        mViewList.add(view);
    }

    public List<ModuleBaseView> getViewList(){
        return mViewList;
    }

    public void responseAllViewIfSuccess(DataResponse response){
        for(int i=0;i<mViewList.size();i++){
            ModuleBaseView view = mViewList.get(i);
            if(view != null) {
                view.onResponseSuccess(response);
            }
        }
    }

    public void responseAllViewIfFailure(Exception e){
        for(int i=0;i<mViewList.size();i++){
            ModuleBaseView view = mViewList.get(i);
            if(view != null) {
                view.onResponseFailure(e);
            }
        }
    }

    public void updateAllViews(BaseViewModel model){
        LogUtil.e(TAG, "updateAllViews 1");
        if(mViewList != null) {
            LogUtil.e(TAG, "updateAllViews 2, viewList size = " + mViewList.size());
            for(int i=0;i<mViewList.size();i++){
                ModuleBaseView view = mViewList.get(i);
                LogUtil.e(TAG, "updateAllViews 3");
                if(view != null) {
                    LogUtil.e(TAG, "updateAllViews 4");
                    view.notifyUpdate(model);
                }
            }
        }
    }

    public List<BaseViewModel> readAllViewModelToList(String moduleFileName){
        List<BaseViewModel> list = ObjectWriter.readAll(moduleFileName);
        LogUtil.e("ppp", "model list size = " + list.size());
        return list;
    }

    public abstract void notifyViewUpdate(BaseViewModel model);
}
