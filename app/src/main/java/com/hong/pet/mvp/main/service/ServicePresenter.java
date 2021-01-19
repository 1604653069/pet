package com.hong.pet.mvp.main.service;

import android.content.Context;

import com.hong.pet.base.BasePresenter;

public class ServicePresenter extends BasePresenter<ServiceView,ServiceModel> {

    public ServicePresenter(Context mContext, ServiceView view) {
        super(mContext, view);
    }

    @Override
    public ServiceModel getmModel() {
        return new ServiceModel(this);
    }
}
