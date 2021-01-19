package com.hong.pet.mvp.main.shop;

import android.content.Context;

import com.hong.pet.base.BasePresenter;

public class ShopPresenter extends BasePresenter<ShopView,ShopModel> {

    public ShopPresenter(Context mContext, ShopView view) {
        super(mContext, view);
    }

    @Override
    public ShopModel getmModel() {
        return new ShopModel(this);
    }
}
