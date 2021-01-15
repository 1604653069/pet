package com.hong.pet.ui;

import android.util.Log;
import com.hong.pet.R;
import com.hong.pet.base.BaseActivity;
import com.hong.pet.model.Request.QueryUser;
import com.hong.pet.model.User;
import com.hong.pet.mvp.login.LoginPresenter;
import com.hong.pet.mvp.login.LoginView;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginView {

    @Override
    protected LoginPresenter getPresenter() {
        return new LoginPresenter(this,this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void dosomething() {
        makeStatusBarTransparent();
        this.mPresenter.login(this,new QueryUser("admin","admin"));
    }
    @Override
    public void loginSuccess(User user) {
        Log.i("TAG",user.toString());
    }

    @Override
    public void loginFail(String errorMsg) {
        T(errorMsg);
    }
}
