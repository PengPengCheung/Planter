package com.gdufs.planter.module.frame.view;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.listener.CustomListener;
import com.gdufs.planter.R;
import com.gdufs.planter.common.BaseViewModel;
import com.gdufs.planter.common.Resource;
import com.gdufs.planter.module.frame.model.CourseInfoModel;
import com.gdufs.planter.module.frame.presenter.FrameViewPresenter;
import com.gdufs.planter.module.planter.model.PlanterViewModel;
import com.gdufs.planter.module.planter.presenter.PlanterMainPresenter;
import com.gdufs.planter.utils.LogUtil;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by peng on 2017/4/8.
 */

public class TitleBarView {

    private static final String TAG = TitleBarView.class.getSimpleName();

    private TextView mTVTitleSelector;
    private OptionsPickerView mCourseOptionsSelector;
    private List<CourseInfoModel> courseInfoModels;

    private TextView mTVPlanterTitle;

    private Activity mActivity;

    public TitleBarView(Activity activity){
        mActivity = activity;
        findViews();
        initViews();
    }

    private void initViews() {
        initOptions();
        initTitle();
    }

    private void initTitle(){
        if(mTVTitleSelector != null){
            String id = FrameViewPresenter.getInstance().getCurrentCourseId(mActivity);
            String name = FrameViewPresenter.getInstance().getCurrentCourseName(mActivity);
            if(!TextUtils.isEmpty(id) && !TextUtils.isEmpty(name)){
                mTVTitleSelector.setText(name);
            }

            mTVTitleSelector.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mCourseOptionsSelector != null){
                        mCourseOptionsSelector.show();
                    }
                }
            });
        }
    }

    private void initOptions(){
        courseInfoModels = new LinkedList<>();
        mCourseOptionsSelector = new OptionsPickerView.Builder(mActivity, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                if(courseInfoModels != null && courseInfoModels.size() > 0){
                    String name = courseInfoModels.get(options1).getPickerViewText();
                    String id = courseInfoModels.get(options1).getmCourseId();
                    LogUtil.e(TAG, "id: " + id + ", name: " + name);
                    mTVTitleSelector.setText(name);
                    FrameViewPresenter.getInstance().setCurrentCourse(id, name, mActivity);
                }
            }
        }).setLayoutRes(R.layout.layout_dialog_picker_view, new CustomListener() {
            @Override
            public void customLayout(View v) {
                LinearLayout mRLSure = (LinearLayout) v.findViewById(R.id.ll_course_picker_sure);
                mRLSure.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mCourseOptionsSelector.returnData();
//                        mCourseOptionsSelector.dismiss();
                    }
                });

            }
        }).isDialog(true).build();

        mCourseOptionsSelector.setPicker(getPickerDataList());
    }

    public void refreshPickerData(){
        if(mCourseOptionsSelector != null){
            mCourseOptionsSelector.setPicker(getPickerDataList());
        }
    }

    public void showPickerText(){
        mTVPlanterTitle.setVisibility(View.GONE);
//        mTVTitleSelector.setBackgroundResource(R.drawable.shape_title_bar_spinner);
        mTVTitleSelector.setVisibility(View.VISIBLE);
    }

    public void showNormalTitleText(){
        mTVTitleSelector.setVisibility(View.GONE);
        mTVPlanterTitle.setVisibility(View.VISIBLE);
    }

    private void findViews() {
        mTVTitleSelector = (TextView) mActivity.findViewById(R.id.tv_title_course_selector);
        mTVPlanterTitle = (TextView) mActivity.findViewById(R.id.tv_title_bar_planter);
    }

    public List<CourseInfoModel> getPickerDataList(){
        List<BaseViewModel> modelList = PlanterMainPresenter.getInstance().readAllViewModelToList(Resource.MODULE_PLANTER_NAME);
        if(modelList != null){
            if(courseInfoModels != null){
                courseInfoModels.clear();
                for(int i=0;i<modelList.size();i++){
                    CourseInfoModel courseInfoModel = convertToCourseInfoModel((PlanterViewModel) modelList.get(i));
                    courseInfoModels.add(courseInfoModel);
                }
            }

        }

        return courseInfoModels;
    }

    private CourseInfoModel convertToCourseInfoModel(PlanterViewModel model){
        CourseInfoModel courseInfoModel = new CourseInfoModel();
        courseInfoModel.setmCourseId(model.getmCourseId());
        courseInfoModel.setmCourseName(model.getmCourseName());
        return courseInfoModel;
    }
}
