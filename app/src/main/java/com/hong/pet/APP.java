package com.hong.pet;

import android.app.Application;
;
import com.zhy.autolayout.config.AutoLayoutConifg;

public class APP extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AutoLayoutConifg.getInstance().useDeviceSize();
    }
}
