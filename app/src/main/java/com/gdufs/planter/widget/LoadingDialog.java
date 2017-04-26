package com.gdufs.planter.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.gdufs.planter.R;
import com.race604.drawable.wave.WaveDrawable;


/**
 * Created by peng on 2017/4/9.
 */

public class LoadingDialog extends Dialog {


    private Context mContext;

    public LoadingDialog(Context context) {
        super(context, R.style.loading_dialog);
        init(context);
    }

    public LoadingDialog(Context context, int themeResId) {
        super(context, themeResId);
        init(context);
    }

    protected LoadingDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        init(context);
    }

    private void init(Context context){
        mContext = context;
        setContentView(initDialogContentView());
        setCanceledOnTouchOutside(false);
    }

    public void setContentView(View view){
        if(view != null){
            super.setContentView(view);
        }
    }

    private View initDialogContentView(){
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_dialog_content_view, null);
        ImageView mIVTree = (ImageView) view.findViewById(R.id.iv_tree);
        WaveDrawable mWaveDrawable = new WaveDrawable(mContext, R.drawable.planter_light);
        mIVTree.setImageDrawable(mWaveDrawable);
        mWaveDrawable.setIndeterminate(true);
        mWaveDrawable.setWaveAmplitude(5);

        return view;
    }
}
