package com.ant_team.car_manager_client_master.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Layout;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ant_team.car_manager_client_master.R;
import com.ant_team.car_manager_client_master.base.BaseActivity;
import com.ant_team.car_manager_client_master.utils.AppUtils;


/**
 * 欢迎界面。
 */
public class WelcomeActivity extends BaseActivity {

    private View view;
    private TextView tvVersion;
    private AlphaAnimation animation = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView()一旦调用, layout就会立刻显示UI；而inflate只会把Layout形成一个以view类实现成的对象，
        // 有需要时再用setContentView(view)显示出来。一般在activity中通过setContentView()将界面显示出来，
        // 但是如果在非activity中如何对控件布局设置操作了，这就需要LayoutInflater动态加载。
        view = View.inflate(this,R.layout.activity_welcome,null);
        setContentView(view);
//        setContentView(R.layout.activity_welcome);
        tvVersion = (TextView) findViewById(R.id.tv_version);
        tvVersion.setText("版本号:" + AppUtils.getVersionName(this));

        //启动后台服务
        enterLogin();
    }

    private  void enterLogin(){
        //设置透明渐变动画
        animation = new AlphaAnimation(0.4f,1.0f);
        animation.setDuration(1500);//设置动画持续时间
        view.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent = new Intent(WelcomeActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

}
