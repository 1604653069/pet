package com.hong.pet.ui;

import com.hong.pet.R;
import com.hong.pet.base.BaseActivity;
import com.hong.pet.model.User;
import com.hong.pet.mvp.login.LoginPresenter;
import com.hong.pet.mvp.login.LoginView;

public class MainActivity extends BaseActivity<LoginPresenter> implements LoginView {

    @Override
    protected LoginPresenter getPresenter() {
        return new LoginPresenter(this,this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void dosomething() {

    }

    @Override
    public void loginSuccess(User user) {

    }

    @Override
    public void loginFail(String errorMsg) {

    }
}