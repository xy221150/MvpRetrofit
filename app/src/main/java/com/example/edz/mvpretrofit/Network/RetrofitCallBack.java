package com.example.edz.mvpretrofit.Network;

public interface RetrofitCallBack<T> {

    void beforeRequest();

    void requstSuccess(T success);

    void requstErorr(Throwable throwable);

    void requestComplete();

}
