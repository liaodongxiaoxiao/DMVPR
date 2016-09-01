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
    private Context context;

    public AppUtils(Context context) {
        this.context = context;
    }

    /**
     * 获取版本名称
     * @return 版本号
     */
    public String getVersionName() {
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

}
