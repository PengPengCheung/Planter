package com.gdufs.planter.common;

/**
 * Created by peng on 2017/3/18.
 */

public class MsgEvent {

    public int what;
    public int arg1;
    public int arg2;
    public Object obj;
    private String msg;

    public MsgEvent(String msg) {
        this.msg = msg;
    }

    public String getMsg(){
        return msg;
    }

}
