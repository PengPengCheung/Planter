package com.gdufs.planter.common;

import android.content.Context;

/**
 * Created by peng on 2017/3/20.
 */

public interface BasePushHandler {
    void handlePush(Context context, MsgEvent event);
}
