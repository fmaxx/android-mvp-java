package com.snzflash.di.components;

import android.app.Application;
import android.content.Context;

import com.snzflash.di.modules.AppModule;
import com.snzflash.di.modules.RestRepositoryModule;
import com.snzflash.di.modules.RetrofitModule;
import com.snzflash.network.rest.IRestRepository;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {AppModule.class, RetrofitModule.class, RestRepositoryModule.class})
@Singleton
public interface AppComponent {

    Application getApplication();
    Context getContext();

    IRestRepository getRestRepository();
}
