package com.hong.pet.base;

import android.content.Context;

public abstract class BasePresenter<V extends BaseView,M extends BaseModel> {
    protected V mView;
    protected M mModel;
    protected Context mContext;
    public BasePresenter(Context mContext,V view){
        this.mContext = mContext;
        this.mView = view;
        this.mModel = getmModel();
    }

    public abstract M getmModel();

}
