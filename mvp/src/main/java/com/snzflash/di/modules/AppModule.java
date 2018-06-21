package com.snzflash.di.modules;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private Application application;

    public AppModule(@NonNull Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application getApplication(){
        return application;
    }

    @Provides
    @Singleton
    Context getContext(){
        return application.getApplicationContext();
    }
}
