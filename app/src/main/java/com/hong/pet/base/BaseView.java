package com.hong.pet.base;

public interface BaseView {
    /**
     * 显示对话框
     */
    void showDialog();

    /**
     * 显示错误信息
     * @param message
     */
    void onFail(String message);
}
