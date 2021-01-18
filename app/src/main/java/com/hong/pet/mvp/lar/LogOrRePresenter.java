package com.hong.pet.mvp.lar;

import android.content.Context;

import com.hong.pet.base.BasePresenter;

public class LogOrRePresenter extends BasePresenter<LogOrReView, LogOrReModel> {

    public LogOrRePresenter(Context mContext, LogOrReView view) {
        super(mContext, view);
    }

    @Override
    public LogOrReModel getmModel() {
        return null;
    }
}
