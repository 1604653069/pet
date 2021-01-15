package com.hong.pet.base;

public class BaseModel<P extends BasePresenter> {
    protected P presenter;
    public BaseModel(P p){
        this.presenter = p;
    }
}
