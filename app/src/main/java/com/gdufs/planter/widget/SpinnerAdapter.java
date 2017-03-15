package com.gdufs.planter.widget;

import android.app.Activity;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by peng on 2017/3/14.
 */

public class SpinnerAdapter<T> {

    private ArrayAdapter<T> mSpinnerAdapter;
    private List<T> mDataList;

    public void setDataList(List<T> list){
        mDataList = list;
        if(mSpinnerAdapter != null && mDataList != null) {
            mSpinnerAdapter.addAll(mDataList);
            mSpinnerAdapter.notifyDataSetChanged();
        }
    }

    public SpinnerAdapter(Activity activity){
        mSpinnerAdapter = new ArrayAdapter<T>(activity, android.R.layout.simple_spinner_dropdown_item);
    }


}
