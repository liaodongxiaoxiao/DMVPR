package com.ldxx.dmvpr.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import com.ldxx.dmvpr.R;


/**
 * Created by wangzhuo-neu
 * on 2016/8/25.
 */

public class AppUtils {
    private static final String TAG = "AppUtils";


    /**
     * 获取版本名称
     *
     * @param context 上下文对象
     * @return 版本号
     */
    public static String getVersionName(Context context) {
        String versionName = "";
        try {
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
            versionName = pi.versionName;
        } catch (Exception e) {
            Log.e("VersionInfo", "Exception", e);
        }
        return versionName;
    }

    public static String getBaseUrl(Context context) {
        return context.getResources().getString(R.string.BASE_HOST);
    }

}
