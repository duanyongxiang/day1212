package com.example.cc.day1212;

import android.app.Application;


/**
 * Created by e531 on 2017/11/13.
 */
public class MyApplication  extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        //进行初使化
        ImageUtils.initImageLoader(this);
    }
}
