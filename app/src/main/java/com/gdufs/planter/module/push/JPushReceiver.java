package com.gdufs.planter.module.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by peng on 2017/3/16.
 */

public class JPushReceiver extends BroadcastReceiver {

    private static final String TAG = "JPushReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = new Bundle();
        Log.e(TAG, "onReceive: " + intent.getAction());
        if(JPushInterface.ACTION_MESSAGE_RECEIVED.equals(intent.getAction())){
            Log.e(TAG, "message: " + bundle.getString(JPushInterface.EXTRA_MESSAGE));
        } else if(JPushInterface.ACTION_NOTIFICATION_OPENED.equals(intent.getAction())){
            Log.e(TAG, "open the notification.");
        }
    }
}
