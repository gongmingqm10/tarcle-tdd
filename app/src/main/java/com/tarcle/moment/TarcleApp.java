package com.tarcle.moment;

import android.app.Application;

public class TarcleApp extends Application {

    private static TarcleApp instance;

    public static TarcleApp getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
