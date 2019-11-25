package com.lijunyan.mvpframe.app;

import androidx.multidex.MultiDexApplication;

/**
 * Created by lijunyan on 2019-11-19
 */
public class App extends MultiDexApplication {

    private static App instance;

    public static synchronized App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

}

