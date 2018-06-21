package com.snzflash.network.rest;

import com.google.gson.annotations.SerializedName;

import java.util.List;

class GetListResponse {

    @SerializedName("items")
    private List<Object> items;
}
