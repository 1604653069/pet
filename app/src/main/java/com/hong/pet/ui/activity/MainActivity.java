package com.hong.pet.ui.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.hong.pet.R;
import com.hong.pet.base.BaseActivity;
import com.hong.pet.model.User;
import com.hong.pet.mvp.login.LoginPresenter;
import com.hong.pet.mvp.login.LoginView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<LoginPresenter> implements LoginView {

    @BindView(R.id.main_fl)
    FrameLayout mainFl;
    @BindView(R.id.menus)
    RadioGroup menus;

    @Override
    protected LoginPresenter getPresenter() {
        return new LoginPresenter(this, this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void dosomething() {
        makeStatusBarTransparent();
        menus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.menu_index:
                        Log.i("TAG","社区");
                        break;
                    case R.id.menu_news:
                        Log.i("TAG","资讯");
                        break;
                    case R.id.menu_shop:
                        Log.i("TAG","商城");
                        break;
                    case R.id.menu_service:
                        Log.i("TAG","服务");
                        break;
                    case R.id.menu_mine:
                        Log.i("TAG","我的");
                        break;
                }
            }
        });
    }

    @Override
    public void loginSuccess(User user) {

    }

    @Override
    public void loginFail(String errorMsg) {

    }

}