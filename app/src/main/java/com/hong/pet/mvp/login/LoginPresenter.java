package com.hong.pet.mvp.login;

import android.content.Context;

import com.hong.pet.base.BasePresenter;
import com.hong.pet.model.Request.QueryUser;
import com.hong.pet.model.User;

public class LoginPresenter extends BasePresenter<LoginView,LoginModel> {

    public LoginPresenter(Context mContext, LoginView view) {
        super(mContext, view);
    }

    @Override
    public LoginModel getmModel() {
        return new LoginModel(this);
    }
    public void login(Context context,QueryUser queryUser){
        this.mModel.login(context,queryUser);
    }
    public void loginSuccess(User user){
        this.mView.loginSuccess(user);
    }
    public void loginFail(String errorMsg){
        this.mView.loginFail(errorMsg);
    }
}
