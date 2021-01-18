package com.hong.pet.mvp.regiter;

import android.content.Context;

import com.hong.pet.base.BasePresenter;

public class RegiterPresenter extends BasePresenter<RegiterView,RegiterModel> {

    public RegiterPresenter(Context mContext, RegiterView view) {
        super(mContext, view);
    }

    @Override
    public RegiterModel getmModel() {
        return new RegiterModel(this);
    }
}
