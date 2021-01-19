package com.hong.pet.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.hong.pet.R;
import com.hong.pet.base.BaseFragment;
import com.hong.pet.mvp.main.news.NewsPresenter;
import com.hong.pet.mvp.main.news.NewsView;

public class FragmentNews extends BaseFragment<NewsPresenter> implements NewsView {

    @Override
    public int getLayoutId() {
        return R.layout.fragment_news;
    }

    @Override
    protected void dosomething() {

    }

    @Override
    protected NewsPresenter getPresenter() {
        return new NewsPresenter(getContext(),this);
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void onFail(String message) {

    }
}
