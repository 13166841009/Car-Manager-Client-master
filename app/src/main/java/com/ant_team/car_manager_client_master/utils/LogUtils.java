package com.ant_team.car_manager_client_master.utils;

import android.util.Log;

/**
 * 日志工具类：Log统一管理
 * Created by zhouyonglong on 2016/3/14.
 */
public class LogUtils {
    public LogUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");//不能被实例化
    }

    public static boolean isDebug = true;//是否需要打印bug,可以在application的onCreat函数中初始化
    private static final String TAG = "way";//tag是一个标识,可以是任意字符串,通常可以使用类名+方法名, 主要是用来在查看日志时提供一个筛选条件.

    //默认tag的函数
    public static void i(String msg) {
        if (isDebug) Log.i(TAG, msg);
    }
    public static void d(String msg) {
        if (isDebug) Log.d(TAG, msg);
    }
    public static void e(String msg) {
        if (isDebug) Log.d(TAG, msg);
    }
    public static void v(String msg) {
        if (isDebug) Log.v(TAG, msg);
    }

    //传入自定义tag的函数
    public static void i(String tag, String msg) {
        if (isDebug) Log.i(tag, msg);
    }
    public static void d(String tag, String msg) {
        if (isDebug) Log.d(tag, msg);
    }
    public static void e(String tag, String msg) {
        if (isDebug) Log.d(tag, msg);
    }
    public static void v(String tag, String msg) {
        if (isDebug) Log.v(tag, msg);
    }
}
