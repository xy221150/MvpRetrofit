package com.example.edz.mvpretrofit.Base;


public interface BaseView<T>{
         void showProgress();
         void disimissProgress();
         void loadDataSuccess(T data);
         void loadDataError(Throwable throwable);
}

