package com.example.edz.mvpretrofit.Mvp.Model;

import com.example.edz.mvpretrofit.Bean.TestBean;
import com.example.edz.mvpretrofit.Network.RetrofitCallBack;
import com.example.edz.mvpretrofit.Network.RetrofitHelper;
import com.example.edz.mvpretrofit.Network.api.Api;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TestModel implements IModel.BaseModel<TestBean> {
    Api api;

    @Override
    public void loadData(Map map, final RetrofitCallBack callBack) {
        api=RetrofitHelper.create(Api.class);
        api.post(map).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                callBack.requstSuccess(response.body());
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                callBack.requstErorr(t);
            }
        });
    }
}
