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
import com.hong.pet.mvp.main.shop.ShopPresenter;
import com.hong.pet.mvp.main.shop.ShopView;

public class FragmentShop extends BaseFragment<ShopPresenter> implements ShopView {

    @Override
    public int getLayoutId() {
        return R.layout.fragment_shop;
    }

    @Override
    protected void dosomething() {

    }

    @Override
    protected ShopPresenter getPresenter() {
        return new ShopPresenter(getContext(),this);
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void onFail(String message) {

    }
}
