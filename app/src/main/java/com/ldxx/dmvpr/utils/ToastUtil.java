package com.ldxx.dmvpr.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Toast 工具类
 */
public class ToastUtil {

    private Context mContext;

    public ToastUtil(Context context){
        this.mContext = context;
    }

    public void showToast(String message){
        Toast.makeText(mContext,message,Toast.LENGTH_LONG).show();
    }
    public void showToast(String message,int time){
        Toast.makeText(mContext,message,time).show();
    }

}
