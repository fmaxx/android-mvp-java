package com.snzflash.di.modules;

import com.snzflash.network.rest.IRestRepository;
import com.snzflash.network.rest.RestInterface;
import com.snzflash.network.rest.RestRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class RestRepositoryModule {

    @Provides
    @Singleton
    IRestRepository getRestRepository(Retrofit retrofit){
        return new RestRepository(retrofit.create(RestInterface.class));
    }
}
