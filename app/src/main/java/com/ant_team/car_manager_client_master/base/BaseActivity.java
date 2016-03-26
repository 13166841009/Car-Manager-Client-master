package com.ant_team.car_manager_client_master.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;

import com.ant_team.car_manager_client_master.utils.AppUtils;
import com.ant_team.car_manager_client_master.utils.LogUtils;


/**
 * 对Activity进行扩展
 * BaseActivity主要也是做一些数据的存储，初始化等。
 * @author zhouyonglong
 * @date 2016-03-15 20:01
 */
public class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtils.i(AppUtils.tag.activity, this.getClass().getSimpleName() + "--->OnCreat");
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtils.i(AppUtils.tag.activity, this.getClass().getSimpleName() + "--->onStart");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtils.i(AppUtils.tag.activity, this.getClass().getSimpleName() + "--->onRestart");
    }
    @Override
    protected void onResume() {
        super.onResume();
        LogUtils.i(AppUtils.tag.activity, this.getClass().getSimpleName() + "--->onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtils.i(AppUtils.tag.activity, this.getClass().getSimpleName() + "--->onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtils.i(AppUtils.tag.activity, this.getClass().getSimpleName() + "--->onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtils.i(AppUtils.tag.activity, this.getClass().getSimpleName() + "--->onDestroy");
    }
}
