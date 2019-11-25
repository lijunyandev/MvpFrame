package com.lijunyan.mvpframe.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.text.TextUtils;

public class PackageUtil {

    /**
     * 获取当前的应用名称
     */
    public static String getNowApplication(Context context) {
        return context.getPackageName();
    }

    /**
     * 获取当前版本号
     */
    public static int getVersionCode(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            return packInfo.versionCode;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * 获取当前版本名
     */
    public static String getVersionName(Context mContext) {
        try {
            PackageManager packageManager = mContext.getPackageManager();
            PackageInfo packInfo = packageManager.getPackageInfo(mContext.getPackageName(), 0);
            return packInfo.versionName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "1.0.0";
    }


    /**
     * 设备号此处痛的 ANDROID_ID
     * 恢复出厂设置会重置
     * 某些设备可能会取不到
     * @param context
     * @return
     */
    public static String getDeviceId(Context context) {
        String androidId = Settings.System.getString(context.getContentResolver(), Settings.System.ANDROID_ID);
        return androidId;
    }

    /**
     * 获取app当前的渠道号或application中指定的meta-data
     *
     * @return 如果没有获取成功(没有对应值, 或者异常)，则返回值为空
     */
    public static String getAppMetaData(Context context, String key) {
        if (context == null || TextUtils.isEmpty(key)) {
            return null;
        }
        String channelNumber = null;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
                if (applicationInfo.metaData != null) {
                    channelNumber = applicationInfo.metaData.getString(key);
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return channelNumber;
    }
}
