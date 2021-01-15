package com.hong.pet.mvp.login;

import android.content.Context;

import com.hong.pet.api.APIServer;
import com.hong.pet.base.BaseModel;
import com.hong.pet.model.Request.QueryUser;
import com.hong.pet.model.User;
import com.hong.pet.retrofit.RetrofitManager;
import com.hong.pet.rxjava.BaseObserver;
import com.hong.pet.rxjava.RxHelper;

public class LoginModel extends BaseModel<LoginPresenter> {
    public LoginModel(LoginPresenter loginPresenter) {
        super(loginPresenter);
    }

    /**
     * 用户登录
     * @param queryUser
     */
    public void login(Context context, QueryUser queryUser){
        RetrofitManager
                .getRetrofit()
                .create(APIServer.class)
                .login(queryUser)
                .compose(RxHelper.observableIO2Main(context))
                .subscribe(new BaseObserver<User>(context) {
                    @Override
                    public void onSuccess(User user) {
                        presenter.loginSuccess(user);
                    }
                    @Override
                    public void onFailure(Throwable t, String errorMessage) {
                        presenter.loginFail(errorMessage);
                    }
                });
    }


}
