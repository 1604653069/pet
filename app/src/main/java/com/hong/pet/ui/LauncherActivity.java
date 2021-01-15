package com.hong.pet.ui;

import android.graphics.Color;

import com.hong.pet.R;
import com.hong.pet.base.BaseActivity;
import com.hong.pet.mvp.launcher.LauncherPresenter;
import com.hong.pet.mvp.launcher.LauncherView;

public class LauncherActivity extends BaseActivity<LauncherPresenter> implements LauncherView {

    @Override
    protected LauncherPresenter getPresenter() {
        return new LauncherPresenter(this,this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_launcher;
    }

    @Override
    protected void dosomething() {
        makeStatusBarTransparent();
        mPresenter.startToLogin();
    }
}
