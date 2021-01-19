package com.hong.pet.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements BaseView {
    protected Toast mToast;
    protected P mPresenter;
    protected View view;
    protected Unbinder unbinder;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(getLayoutId(),container,false);
        bindView(view);
        mPresenter = getPresenter();
        dosomething();
        return view;
    }
    protected void bindView(View view){
        unbinder = ButterKnife.bind(this, view);
    }
    public abstract int getLayoutId();

    protected abstract void dosomething();

    protected abstract P getPresenter();


    protected void T(String message){
        if(mToast!=null){
            mToast.setText(message);
            mToast.setDuration(Toast.LENGTH_SHORT);
            mToast.show();
        }
    }

}
