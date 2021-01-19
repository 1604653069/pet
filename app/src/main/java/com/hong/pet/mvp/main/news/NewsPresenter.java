package com.hong.pet.mvp.main.news;

import android.content.Context;

import com.hong.pet.base.BasePresenter;

public class NewsPresenter extends BasePresenter<NewsView,NewsModel> {

    public NewsPresenter(Context mContext, NewsView view) {
        super(mContext, view);
    }

    @Override
    public NewsModel getmModel() {
        return new NewsModel(this);
    }
}
