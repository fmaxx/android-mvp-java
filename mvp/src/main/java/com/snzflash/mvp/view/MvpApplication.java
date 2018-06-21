package com.snzflash.mvp.view;

import android.support.multidex.MultiDexApplication;

import com.snzflash.di.components.AppComponent;

public class MvpApplication extends MultiDexApplication {

    protected AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        inject();
    }

    protected void inject() {

    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
