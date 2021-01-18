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
import com.hong.pet.ui.fragment.FragmentIndex;
import com.hong.pet.ui.fragment.FragmentMine;
import com.hong.pet.ui.fragment.FragmentNews;
import com.hong.pet.ui.fragment.FragmentService;
import com.hong.pet.ui.fragment.FragmentShop;

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
        getSupportFragmentManager().beginTransaction().replace(R.id.main_fl,new FragmentIndex()).commit();
        menus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.menu_index:
                        Log.i("TAG","社区");
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_fl,new FragmentIndex()).commit();
                        break;
                    case R.id.menu_news:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_fl,new FragmentNews()).commit();
                        Log.i("TAG","资讯");
                        break;
                    case R.id.menu_shop:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_fl,new FragmentShop()).commit();
                        Log.i("TAG","商城");
                        break;
                    case R.id.menu_service:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_fl,new FragmentService()).commit();
                        Log.i("TAG","服务");
                        break;
                    case R.id.menu_mine:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_fl,new FragmentMine()).commit();
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