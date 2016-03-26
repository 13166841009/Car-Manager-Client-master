package com.ant_team.car_manager_client_master.base;

import android.app.Application;
import android.content.Context;

/**
 * 在启动这个应用程序时，首先运行在AndroidManifest中注册的Application,也就是”name“的值代表的Application。
 * 在初始运行这个应用时我们需要先加载一些数据或其他，做一些初始化的操作，这时，我们就需要在BaseApplication中定义。
 * Created by zhouyonglong on 2016/3/18.
 */
public class BaseApplication extends Application{

    private static String mLock = "LOCK";
    /**
     * 单例模式中获取唯一的MyApplication实例
     */
    private BaseApplication(){}
    private static BaseApplication mApplication = new BaseApplication();
    public static BaseApplication getInstance(){return mApplication;}

    /**
     * 获取Context，此方法：内存优化、使用方便
     */
    public static Context getContext(){
        return mApplication.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.mApplication = this;
        /**
         * 做一些初始化的处理：初始化数据库，化图片缓存，初始化地图等。
         */
    }
}
