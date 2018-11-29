package com.example.edz.mvpretrofit.Mvp.Model;

import com.example.edz.mvpretrofit.Network.RetrofitCallBack;

import java.util.Map;

public class IModel {
    public interface BaseModel<T>{
        void loadData(String name, RetrofitCallBack<T> callBack);
    }
}
