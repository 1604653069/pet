package com.hong.pet.mvp.login;

import com.hong.pet.base.BaseView;
import com.hong.pet.model.User;

public interface LoginView extends BaseView {

    void loginSuccess(User user);
    void loginFail(String errorMsg);
}
