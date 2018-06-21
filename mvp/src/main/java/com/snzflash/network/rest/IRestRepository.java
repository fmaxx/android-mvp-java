package com.snzflash.network.rest;

import io.reactivex.Single;

public interface IRestRepository {
    Single<GetListResponse> loadData();
}
