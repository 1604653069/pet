package com.hong.pet.ui.fragment;

import com.hong.pet.R;
import com.hong.pet.base.BaseFragment;
import com.hong.pet.mvp.main.mine.MinePresenter;
import com.hong.pet.mvp.main.mine.MineView;

public class FragmentMine extends BaseFragment<MinePresenter> implements MineView {

    @Override
    public int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void dosomething() {

    }

    @Override
    protected MinePresenter getPresenter() {
        return new MinePresenter(getContext(),this);
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void onFail(String message) {

    }
}
