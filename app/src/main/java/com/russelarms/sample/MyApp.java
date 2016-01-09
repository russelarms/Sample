package com.russelarms.sample;

import android.app.Application;
import android.content.Context;

/**
 * Created by Ruslan on 09.01.2016.
 */
public class MyApp extends Application {

    private static MyApp instance = null;

    public static Context getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

}
