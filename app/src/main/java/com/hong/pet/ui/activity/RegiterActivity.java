package com.hong.pet.ui.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.hong.pet.R;
import com.hong.pet.base.BaseActivity;
import com.hong.pet.mvp.regiter.RegiterPresenter;
import com.hong.pet.mvp.regiter.RegiterView;
import butterknife.BindView;
import butterknife.OnClick;

public class RegiterActivity extends BaseActivity<RegiterPresenter> implements RegiterView {
    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_content)
    TextView titleContent;

    @Override
    protected void dosomething() {
        makeStatusBarTransparent();
        titleContent.setText("注册");
    }

    @Override
    protected RegiterPresenter getPresenter() {
        return new RegiterPresenter(this, this);
    }
    @OnClick(R.id.title_back)
    public void onTitleBack(){
        finish();
    }
    @Override
    public int getLayoutId() {
        return R.layout.activity_register;
    }
}
