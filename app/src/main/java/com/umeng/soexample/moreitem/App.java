package com.umeng.soexample.moreitem;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.umeng.soexample.moreitem.net.HttpNet;

/**
 * data:2018/12/9
 * author: HJL (磊)
 * function:
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        HttpNet.init();
        Fresco.initialize(this);
    }
}
