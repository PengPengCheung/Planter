package com.gdufs.planter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by peng on 2017/3/11.
 */

public class JPushBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        Log.e("ppp", "receive");
        Toast.makeText(context, "test", Toast.LENGTH_SHORT).show();
//        Log.e("ppp", "bundle: " + bundle.toString());
        if (JPushInterface.ACTION_MESSAGE_RECEIVED.equals(intent.getAction())) {
            System.out.println("收到了自定义消息。消息内容是：" + bundle.getString(JPushInterface.EXTRA_MESSAGE));
            // 自定义消息不会展示在通知栏，完全要开发者写代码去处理
        }
    }
}
