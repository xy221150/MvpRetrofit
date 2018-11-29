package com.example.edz.mvpretrofit.Network.api;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface Api {
    @POST("")
    Call<Void> post(@QueryMap Map map);
}
