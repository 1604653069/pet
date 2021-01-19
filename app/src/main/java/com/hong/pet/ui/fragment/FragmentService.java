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
import com.hong.pet.mvp.main.service.ServicePresenter;
import com.hong.pet.mvp.main.service.ServiceView;

public class FragmentService extends BaseFragment<ServicePresenter> implements ServiceView {

    @Override
    public int getLayoutId() {
        return R.layout.fragment_service;
    }

    @Override
    protected void dosomething() {

    }

    @Override
    protected ServicePresenter getPresenter() {
        return new ServicePresenter(getContext(),this);
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void onFail(String message) {

    }
}
