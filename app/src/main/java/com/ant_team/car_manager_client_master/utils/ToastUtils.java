package com.ant_team.car_manager_client_master.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Toast统一管理类
 * Created by zhouyonglong on 2016/3/20.
 */
public class ToastUtils {
    public ToastUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static boolean isShow = true;

    /**
     * 短时间显示Toast
     * @param context
     * @param msg
     */
    public static void showMessage(Context context, CharSequence msg) {
        if (isShow) Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 短时间显示Toast
     * @param context
     * @param msg
     */
    public static void showMessage(Context context, int msg) {
        if (isShow) Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 长时间显示Toast
     * @param context
     * @param msg
     */
    public static void showMessageLong(Context context , CharSequence msg){
        if (isShow) Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }

    /**
     * 长时间显示Toast
     * @param context
     * @param msg
     */
    public static void showMessageLong(Context context , int msg){
        if (isShow) Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }

    /**
     * 自定义显示Toast时间
     * @param context
     * @param msg
     * @param duration
     */
    public static void show(Context context , CharSequence msg , int duration){
        if (isShow) Toast.makeText(context, msg, duration).show();
    }

    /**
     * 自定义显示Toast时间
     * @param context
     * @param msg
     * @param duration
     */
    public static void show(Context context , int msg , int duration){
        if (isShow) Toast.makeText(context, msg, duration).show();
    }
}
