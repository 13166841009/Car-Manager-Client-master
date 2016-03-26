package com.ant_team.car_manager_client_master.activity;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ant_team.car_manager_client_master.R;
import com.ant_team.car_manager_client_master.base.BaseActivity;
import com.ant_team.car_manager_client_master.utils.StringUtils;
import com.ant_team.car_manager_client_master.utils.ToastUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhouyonglong on 2016/3/22.
 */
public class LoginActivity extends BaseActivity{

    private Context mContext;

    private RelativeLayout rl_user;
    private ImageView mLoginPic;
    private ProgressBar mProgressBar;
    private EditText mLoginName;
    private EditText mPassword;
    private CheckBox mChkSavePassword;
    private Button mLogin;
    private Button register;
    private TextView mTVForgetPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // 指定屏幕方向为竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        // 实现淡入浅出的效果
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
        mContext = this;
        findView();
        init();
    }

    private void findView() {
        rl_user = (RelativeLayout) findViewById(R.id.rl_user);
        mLoginPic = (ImageView)findViewById(R.id.login_picture);
        mProgressBar = (ProgressBar) findViewById(R.id.pb_loading);
        mLoginName = (EditText) findViewById(R.id.account);
        mPassword = (EditText) findViewById(R.id.password);
        mChkSavePassword = (CheckBox) findViewById(R.id.id_cb_rememberpwd);
        mLogin = (Button) findViewById(R.id.login);
        register = (Button) findViewById(R.id.register);
        mTVForgetPwd = (TextView) findViewById(R.id.tv_forger_password);
    }

    private void init() {
        //就是加载一个动画效果，那个动画效果是写在文件res/anim/login_anim.xml里面的，你可以用一个view去start这个动画效果，那么界面上就会有相应的动画效果了
        Animation anim = AnimationUtils.loadAnimation(mContext,R.anim.login_anim);
        //为true的话，控件将停留在动画执行结束的状态
        anim.setFillAfter(true);
        //给插件设置动画效果
        rl_user.startAnimation(anim);

        mLogin.setOnClickListener(loginOnClickListener);
    }

    /**
     * 点击登陆之后，修改登陆按钮上面的字，隐藏mLoginPic,显示mProgressBar.
     * 若用户名或密码为空，则还原上述操作。
     */
    private View.OnClickListener loginOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mLogin.setText("正在登录，请稍后...");
            mLoginPic.setVisibility(View.GONE);
            mProgressBar.setVisibility(View.VISIBLE);
            String loginname = mLoginName.getText().toString();
            String loginpwd = mPassword.getText().toString();
            if(StringUtils.isEmpty(loginname)||StringUtils.isEmpty(loginpwd)){
                ToastUtils.showMessage(mContext, "用户名或密码不能为空！");
                mLoginPic.setVisibility(View.VISIBLE);
                mProgressBar.setVisibility(View.GONE);
                mLogin.setText("登录");
                return;
            }

            //拼装登陆数据
            Map<String , String > parm = new HashMap<String, String>();
            parm.put("loginname",loginname);
            parm.put("loginpwd",loginpwd);



        }
    };
}
