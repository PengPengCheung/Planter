package com.gdufs.planter.module.attendance;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gdufs.planter.module.attendance.view.AttendanceView;

/**
 * Created by peng on 2017/3/15.
 */

public class AttendanceFragment extends Fragment {

    AttendanceView mAttendanceView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mAttendanceView = new AttendanceView(getActivity(), inflater, container, savedInstanceState);

        return mAttendanceView.getUniversalListView();
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
