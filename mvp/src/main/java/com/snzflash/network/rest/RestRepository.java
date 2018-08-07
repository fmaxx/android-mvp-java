package com.snzflash.network.rest;

import com.snzflash.network.RxRepositoryBase;

import io.reactivex.Single;

public class RestRepository extends RxRepositoryBase implements IRestRepository {

    private RestInterface service;

    public RestRepository(RestInterface service) {
        this.service = service;
    }

    @Override
    public Single<GetListResponse> loadData() {
        if (service == null) {
            return Single.error(new Error("Service"));
        }

        return addRetryWhen(service.loadData());
    }
}
