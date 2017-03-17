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
        Log.e("ppp", "receive：" + intent.getAction());
        Toast.makeText(context, "test", Toast.LENGTH_SHORT).show();

        Log.e("ppp", "msg: "+bundle.getString(JPushInterface.EXTRA_MESSAGE));

//        Log.e("ppp", "bundle: " + bundle.toString());
        if (JPushInterface.ACTION_MESSAGE_RECEIVED.equals(intent.getAction())) {
            System.out.println("收到了自定义消息。消息内容是：" + bundle.getString(JPushInterface.EXTRA_MESSAGE));
            // 自定义消息不会展示在通知栏，完全要开发者写代码去处理

        }

        if(JPushInterface.ACTION_NOTIFICATION_OPENED.equals(intent.getAction())){
            Log.e("ppp", "收到了自定义消息为：" + bundle.getString(JPushInterface.EXTRA_ALERT));
            Log.e("ppp", "收到了自定义消息为：" + bundle.getString(JPushInterface.EXTRA_EXTRA));

            Intent startIntent = new Intent(context, PushOpenTestActivity.class);
            bundle.putString("from", "push");
            startIntent.putExtras(bundle);
            startIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP );
            context.startActivity(startIntent);

        }
    }
}
