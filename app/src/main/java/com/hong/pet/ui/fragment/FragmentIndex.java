package com.hong.pet.ui.fragment;


import android.widget.TextView;

import com.hong.pet.R;
import com.hong.pet.base.BaseFragment;
import com.hong.pet.mvp.main.index.IndexPresenter;
import com.hong.pet.mvp.main.index.IndexView;

import butterknife.BindView;

public class FragmentIndex extends BaseFragment<IndexPresenter> implements IndexView {


    @BindView(R.id.index_tv)
    TextView indexTv;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_index;
    }

    @Override
    protected void dosomething() {

    }

    @Override
    protected IndexPresenter getPresenter() {
        return new IndexPresenter(getContext(),this);
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void onFail(String message) {

    }
}
