package com.example.edz.mvpretrofit.Mvp.Model;

import com.example.edz.mvpretrofit.Network.RetrofitCallBack;

import java.util.Map;

public class IModel {
    public interface BaseModel<T>{
        void loadData(Map<Object, Object> map, RetrofitCallBack<T> callBack);
    }
}
