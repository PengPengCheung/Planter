package com.gdufs.planter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.gdufs.planter.common.MsgEvent;
import com.gdufs.planter.common.Resource;

import org.greenrobot.eventbus.EventBus;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by peng on 2017/3/11.
 */

public class JPushBroadcastReceiver extends BroadcastReceiver {

    MsgEvent event = new MsgEvent("From JPUSH Message");

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        Log.e("ppp", "receive：" + intent.getAction());
        Toast.makeText(context, "test", Toast.LENGTH_SHORT).show();

        Log.e("ppp", "msg: "+bundle.getString(JPushInterface.EXTRA_MESSAGE));

//        Log.e("ppp", "bundle: " + bundle.toString());
        if (JPushInterface.ACTION_MESSAGE_RECEIVED.equals(intent.getAction())) {
            event.obj = bundle.getString(JPushInterface.EXTRA_MESSAGE);
            System.out.println("收到了自定义消息。消息内容是：" + event.obj);
            EventBus.getDefault().postSticky(event);
            // 自定义消息不会展示在通知栏，完全要开发者写代码去处理

        }

        if(JPushInterface.ACTION_NOTIFICATION_OPENED.equals(intent.getAction())){
            Log.e("ppp", "收到了自定义消息为：" + bundle.getString(JPushInterface.EXTRA_ALERT));
            Log.e("ppp", "收到了自定义消息为：" + bundle.getString(JPushInterface.EXTRA_MESSAGE));



//            event.obj = bundle.getString(JPushInterface.EXTRA_MESSAGE);

            Intent startIntent = new Intent(context, ClassInteractionActivity.class);
            bundle.putString("from", "push");
            startIntent.putExtras(bundle);
            startIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP );
            context.startActivity(startIntent);

        }
    }
}
