package com.gdufs.planter.module.homework.view;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.gdufs.planter.R;
import com.gdufs.planter.common.BaseViewDBModel;
import com.gdufs.planter.common.BaseViewModel;
import com.gdufs.planter.common.DataResponse;
import com.gdufs.planter.common.ModuleBaseView;
import com.gdufs.planter.common.Resource;
import com.gdufs.planter.module.homework.model.HomeworkViewModel;
import com.gdufs.planter.module.homework.presenter.HomeworkPresenter;
import com.gdufs.planter.utils.CommonUtil;
import com.gdufs.planter.widget.UniversalListView;

import java.util.List;

/**
 * Created by peng on 2017/3/21.
 */

public class HomeworkView implements ModuleBaseView {

    private UniversalListView mView;

    private Activity mActivity;

    public HomeworkView(Activity context, View view){
        mActivity = context;
        mView = new UniversalListView(context, view);
        initParams();
        setListeners();

    }

    private void initParams(){
        HomeworkPresenter.getInstance().registerView(this);
        mView.getAdapter().addData(getHomeworkViewModelList());
    }

    private void setListeners(){
        mView.setItemViewListener(new UniversalListView.ItemViewListener() {

            @Override
            public RecyclerView.ViewHolder createItemViewHolder(Context context) {
                View view = LayoutInflater.from(context).inflate(R.layout.fragment_course_homework_item, null);
                return new HomeworkItemView(view, context);
            }

            @Override
            public void setItemViewContent(RecyclerView.ViewHolder holder, int pos) {
                int size = mView.getAdapter().getData().size();
                if(pos >= size){
                    return;
                }
                HomeworkViewModel model = (HomeworkViewModel) mView.getAdapter().getData().get(pos);
                ((HomeworkItemView) holder).setViews(model);
            }
        });
    }

    public View getUniversalListView(){
        return mView.getUniversalListView();
    }

    private List<BaseViewModel> getHomeworkViewModelList(){
        return HomeworkPresenter.getInstance().readAllViewModelToList(CommonUtil.getCurrentSelectedCourseId(mActivity));
    }

    @Override
    public void update(BaseViewModel model) {

        if(mView != null){
            mView.getAdapter().clearData();
            mView.getAdapter().addData(getHomeworkViewModelList());
        }

//        HomeworkViewModel homeworkViewModel = (HomeworkViewModel) model;
//        mView.getAdapter().addData(0, homeworkViewModel);
    }

    @Override
    public void onResponseSuccess(DataResponse response) {
        update((BaseViewModel) response.getData());
    }

    @Override
    public void onResponseFailure(Exception e) {

    }
}
