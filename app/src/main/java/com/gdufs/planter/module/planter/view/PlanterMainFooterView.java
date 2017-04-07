package com.gdufs.planter.module.planter.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.gdufs.planter.R;
import com.gdufs.planter.common.Resource;
import com.gdufs.planter.module.planter.PlanterViewSignal;
import com.gdufs.planter.module.planter.presenter.PlanterMainPresenter;
import com.gdufs.planter.utils.LogUtil;
import com.gdufs.planter.utils.NetworkUtil;
import com.gdufs.planter.utils.ResultCallback;
import com.gdufs.planter.widget.FooterViewHolder;
import com.gdufs.planter.widget.ItemViewHolder;

import java.util.HashMap;
import java.util.Map;

import com.gdufs.planter.widget.MaterialDialog;

/**
 * Created by peng on 2017/3/25.
 */

public class PlanterMainFooterView extends FooterViewHolder {

    private static final String TAG = PlanterMainFooterView.class.getSimpleName();

    private ImageView mIVCourseAdd;

    private OnChildViewActionListener mListener;

    private Context mActivity;

    public PlanterMainFooterView(View itemView, Context activity) {
        super(itemView);
        mActivity = activity;
        findViews(itemView);
        setViews();
    }

    public void setOnChildViewActionListener(OnChildViewActionListener l){
        mListener = l;
    }

    private void findViews(View itemView) {
        mIVCourseAdd = (ImageView) itemView.findViewById(R.id.img_course_add);
    }

    private void setViews(){
        mIVCourseAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mListener != null){
                    mListener.onAction(PlanterViewSignal.FOOTER_ITEM_ADD_COURSE);
                }


            }
        });
    }


}
