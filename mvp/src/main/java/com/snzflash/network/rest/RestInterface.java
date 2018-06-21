package com.snzflash.network.rest;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface RestInterface {

    @GET("/api/loadData")
    Single<GetListResponse> loadData(
//            @Header("x-id-token") String token,
//            @Query("uid") String uid,
//            @Query("nextPageToken") String nextPageToken,
//            @Query("filter") Map<String, String> filter
    );
}
