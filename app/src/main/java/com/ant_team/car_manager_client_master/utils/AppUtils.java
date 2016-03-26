package com.ant_team.car_manager_client_master.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

/**
 * 跟App相关的辅助类
 */
public class AppUtils {
    private AppUtils() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 获取应用程序名称
     */
    public static String getAppName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    context.getPackageName(), 0);
            int labelRes = packageInfo.applicationInfo.labelRes;
            return context.getResources().getString(labelRes);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取本地应用程序版本名称信息
     * @param context
     * @return 当前应用的版本名称
     */
    public static String getVersionName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    context.getPackageName(), 0);
            return packageInfo.versionName;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取本地应用程序版本的版本号
     * @param context
     * @return
     */
    private int getVersionCode(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            // 获取包的信息
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionCode;
        } catch (NameNotFoundException e) {
            // 没有找到包名的时候会走此异常。
            e.printStackTrace();
        }
        return -1;
    }

    //  Socket Connect
    public static class net{
        public static final int port = 30000;
        public static final String IP = "10.163.5.241";
        public static final String tip = "消息类型错误！";
    }

    //  Connect Type
    public static final class socket{

    }

    public static final class login {
        public static final String loginFlag = "LOGIN_FLAG";
        public static final String account = "USER_ACCOUNT";
        public static final String password = "USER_PASSWORD";
        public static final String portrait = "USER_PORTRAIT";
        public static final String userName = "USER_NAME";
        public static final String sex = "USER_SEX";
        public static final String grade = "USER_GRADE";
        public static final String classes = "USER_CLASSES";
    }

    public static final class tag {
        public static final String activity = "tag_activity";
        public static final String network = "tag_network";
        public static final String error = "tag_error";
    }

    //BroadcastReceiver
    public static final class broadcast {

    }
    //  Broadcast Message
    public static final class message {
        public static final String sendMessage = "SERVICE_MSG";
        public static final String login = "RECEIVE_LOGIN_MSG";
        public static final String test = "TEST_MSG";
    }

    public static final class service{
        public static final int CODE_UPDATE_DIALOG = 0;
        public static final int CODE_URL_ERROR = 1;
        public static final int CODE_NET_ERROR = 2;
        public static final int CODE_JSON_ERROR = 3;
    }

}