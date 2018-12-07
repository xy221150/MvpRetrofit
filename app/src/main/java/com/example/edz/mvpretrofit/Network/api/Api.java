package com.example.edz.mvpretrofit.Network.api;

import com.example.edz.mvpretrofit.Bean.TestBean;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {
    @POST("weatherApi")
    Observable<TestBean> post(@Query("name") String name);
}
