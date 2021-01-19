package com.hong.pet.ui.fragment.index;

import com.hong.pet.R;
import com.hong.pet.base.BaseFragment;
import com.hong.pet.mvp.main.index.IndexPresenter;
import com.hong.pet.mvp.main.index.IndexView;

public class ChannelFragment extends BaseFragment<IndexPresenter> implements IndexView {
    @Override
    public int getLayoutId() {
        return R.layout.fragment_index_pd;
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
