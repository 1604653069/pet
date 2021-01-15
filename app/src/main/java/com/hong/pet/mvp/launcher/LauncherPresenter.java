package com.hong.pet.mvp.launcher;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;

import com.hong.pet.base.BasePresenter;
import com.hong.pet.ui.LoginActivity;

public class LauncherPresenter extends BasePresenter<LauncherView,LauncherModel> {

    public LauncherPresenter(Context mContext, LauncherView view) {
        super(mContext, view);
    }

    @Override
    public LauncherModel getmModel() {
        return new LauncherModel(this);
    }
    public void startToLogin(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mContext.startActivity(new Intent(mContext, LoginActivity.class));
            }
        },1500);
    }
}
