package com.hong.pet.mvp.main.mine;

import android.content.Context;

import com.hong.pet.base.BasePresenter;

public class MinePresenter extends BasePresenter<MineView,MineModel> {

    public MinePresenter(Context mContext, MineView view) {
        super(mContext, view);
    }

    @Override
    public MineModel getmModel() {
        return new MineModel(this);
    }
}
