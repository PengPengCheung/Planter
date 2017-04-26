package com.gdufs.planter.module.planter.presenter;

import android.content.Context;

import com.gdufs.planter.common.BaseViewModel;
import com.gdufs.planter.common.DataResponse;
import com.gdufs.planter.common.ModuleBasePresenter;
import com.gdufs.planter.common.PersistenceManager;
import com.gdufs.planter.common.Resource;
import com.gdufs.planter.common.ResponseDataConverter;
import com.gdufs.planter.module.planter.PlanterDataManager;
import com.gdufs.planter.module.planter.model.PlanterViewModel;
import com.gdufs.planter.utils.JsonUtil;
import com.gdufs.planter.utils.LogUtil;
import com.gdufs.planter.utils.NetworkUtil;
import com.gdufs.planter.utils.PreferenceHelper;
import com.gdufs.planter.utils.ResultCallback;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by peng on 2017/3/25.
 */

public class PlanterMainPresenter extends ModuleBasePresenter {

    private static PlanterMainPresenter mInstance = null;

    private static final String TAG = PlanterMainPresenter.class.getSimpleName();

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
    public List<BaseViewModel> readAllViewModelToList(String moduleFileName) {
        return PlanterDataManager.getInstance().readAllPlanterViewModel();
    }

    @Override
    public void notifyViewUpdate(BaseViewModel model) {
        updateAllViews(model);
    }

    @Override
    public void notifyBonusUpdate(String courseId) {
        BaseViewModel model = new BaseViewModel();
        model.setmCourseId(courseId);
        updateAllViews(model);
    }

    public void plant(PlanterViewModel model){
        PlanterDataManager.getInstance().plantTree(model);
    }


    public void sendCourseCode(String courseCode, Context context){

        Map<String, Object> params = new HashMap<>();
        params.put(Resource.KEY.KEY_STU_COURSE_CODE, courseCode);
        params.put(Resource.KEY.KEY_STUDENT_ID, PreferenceHelper.getInstance(context).getString(Resource.KEY.KEY_STUDENT_ID, ""));
        NetworkUtil.post(Resource.PlanterURL.PLANTER_ADD_COURSE, params, new ResultCallback<String>() {

            @Override
            public void onSuccess(String response) {
                LogUtil.e(TAG, "courseCode response" + response);

                DataResponse<PlanterViewModel> dataResponse = ResponseDataConverter.convertToPlanterViewModel(response);

                if(dataResponse != null){
                    if(dataResponse.getData() != null && dataResponse.getData().getmCourseId() != null){
                        PlanterDataManager.getInstance().storeNewCourse(dataResponse.getData());
                        responseAllViewIfSuccess(dataResponse);
                        return;
                    }
                }

                responseAllViewIfFailure(new Exception());

            }

            @Override
            public void onFailure(Exception e) {
                e.printStackTrace();
                responseAllViewIfFailure(e);
//                mDialog.dismiss();
            }
        });

    }
}
