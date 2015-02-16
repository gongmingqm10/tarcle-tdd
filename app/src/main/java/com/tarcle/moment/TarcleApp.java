package com.tarcle.moment;

import android.app.Application;

public class TarcleApp extends Application {

    private TarcleApp instance;

    public TarcleApp getInstance() {
        return instance;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

}
