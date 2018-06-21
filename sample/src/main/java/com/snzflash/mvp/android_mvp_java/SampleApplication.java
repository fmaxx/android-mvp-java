package com.snzflash.mvp.android_mvp_java;

import android.util.Log;

import com.snzflash.di.components.DaggerAppComponent;
import com.snzflash.di.modules.AppModule;
import com.snzflash.di.modules.RetrofitModule;
import com.snzflash.mvp.view.MvpApplication;

public class SampleApplication extends MvpApplication {
    @Override
    protected void inject() {
        super.inject();
        appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .retrofitModule(new RetrofitModule("REST_API_END_POINT"))
                .build();
        Log.i("~~ ", appComponent.toString());
    }
}
