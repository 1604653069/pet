package com.hong.pet.base;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView {
    protected P mPresenter;
    protected Toast mToast;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        init();
        dosomething();
    }

    protected void init(){
        mPresenter = getPresenter();
        mToast = Toast.makeText(this, "", Toast.LENGTH_SHORT);
    }

    protected void T(String message){
        if(mToast!=null){
            mToast.setText(message);
            mToast.show();
        }
    }
    /**
     * 全屏显示，状态栏会消失
     */
    protected void hideToolBar(){
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    /**
     * 状态栏透明
     */
    protected void makeStatusBarTransparent() {
        hideActionBar();
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            return;
        }
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            int option = window.getDecorView().getSystemUiVisibility() | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
            window.getDecorView().setSystemUiVisibility(option);
            window.setStatusBarColor(Color.TRANSPARENT);
        } else {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }
    /**
     * 隐藏actionBar
     */
    protected void hideActionBar(){
        if(getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }
    }
    @Override
    public void showDialog() {

    }

    @Override
    public void onFail(String message) {

    }
    protected abstract void dosomething();

    protected abstract P getPresenter();

    public abstract int getLayoutId();

}
