package com.ant_team.car_manager_client_master.model.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;

/**
 * 自定义一个带清除功能的输入框控件CleanableEditText,仿IOS的输入框
 * Created by zhouyonglong on 2016/3/17.
 */
public class CleanableEditText extends EditText {

    /**
     * 删除按钮的引用
     */
    private Drawable mRightDrawable;
    /**
     * 控件是否有焦点
     */
    private boolean isHasFocus;

    public CleanableEditText(Context context) {
        super(context);
        init();
    }

    public CleanableEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CleanableEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        //获取EditText的DrawableRight,假如没有设置我们就使用默认的图片
        Drawable[] drawables = this.getCompoundDrawables();
        //取得right位置的Drawable，即在布局文件中设置的android：drawableRight
        mRightDrawable = drawables[2];

        //设置焦点变化的监听
        this.setOnFocusChangeListener(new FocusChangeListenerImpl());
        //设置EditText文字变化的监听
        this.addTextChangedListener(new TextWatcherImpl());
        //初始化时让右边clean图标不可见
        setClearDrawableVisible(false);
    }

    //自定义聚焦监视器
    private class FocusChangeListenerImpl implements OnFocusChangeListener {
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            isHasFocus = hasFocus;
            if (isHasFocus) {
                boolean isVisible = getText().toString().length() >= 1;
                setClearDrawableVisible(isVisible);
            } else {
                setClearDrawableVisible(false);
            }
        }
    }

    // 隐藏或者显示右边clean的图标
    protected void setClearDrawableVisible(boolean isVisible) {
        //清除rightDrawable
        Drawable rightDrawable = isVisible ? mRightDrawable : null;
        //使用代码设置该控件left,top,right,botton处的图标
        setCompoundDrawables(getCompoundDrawables()[0],
                getCompoundDrawables()[1], rightDrawable, getCompoundDrawables()[3]);
    }

    //当输入结束后判断是否显示右边clean的图标
    private class TextWatcherImpl implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            boolean isVisible = getText().toString().length() >= 1 && isHasFocus;
            setClearDrawableVisible(isVisible);
        }
    }

    /**
     * 当手指抬起的位置在clean的图标的区域 我们将此视为进行清除操作 getWidth():得到控件的宽度
     * event.getX():抬起时的坐标(改坐标是相对于控件本身而言的)
     * getTotalPaddingRight():clean的图标左边缘至控件右边缘的距离
     * getPaddingRight():clean的图标右边缘至控件右边缘的距离 于是: getWidth() -
     * getTotalPaddingRight()表示: 控件左边到clean的图标左边缘的区域 getWidth() -
     * getPaddingRight()表示: 控件左边到clean的图标右边缘的区域 所以这两者之间的区域刚好是clean的图标的区域
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:
                boolean isClean = (event.getX() > (getWidth() - getTotalPaddingRight()))
                        && (event.getY() < (getWidth() - getPaddingRight()));
                if (isClean)setText("");
                break;
            default:break;
        }
        return super.onTouchEvent(event);
    }

    /**
     * 设置一个晃动动画，以提示用户输入
     */
    public void setShakeAnimation(){
        this.setAnimation(shakeAnimation(5));
    }

    /**
     * 1秒钟晃动多少下
     * @param CycleTimes
     * @return
     */
    public Animation shakeAnimation(int CycleTimes){
        Animation translateAnimation = new TranslateAnimation(0,10,0,10);
        translateAnimation.setInterpolator(new CycleInterpolator(CycleTimes));
        translateAnimation.setDuration(1000);
        return translateAnimation;
    }
}
