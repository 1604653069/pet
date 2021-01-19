package com.hong.pet.mvp.main.index;

import android.content.Context;

import com.hong.pet.base.BasePresenter;

public class IndexPresenter extends BasePresenter<IndexView,IndexModel> {

    public IndexPresenter(Context mContext, IndexView view) {
        super(mContext, view);
    }

    @Override
    public IndexModel getmModel() {
        return new IndexModel(this);
    }
}
