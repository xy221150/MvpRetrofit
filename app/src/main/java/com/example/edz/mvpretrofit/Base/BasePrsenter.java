package com.example.edz.mvpretrofit.Base;


import com.example.edz.mvpretrofit.Network.RetrofitCallBack;


//V继承BaseView T接口bean
public class BasePrsenter<V extends BaseView,T>implements RetrofitCallBack<T> {
    V view;

    public void attrchView(V view){
        this.view=view;
    }

    @Override
    public void beforeRequest() {
        view.showProgress();
    }

    @Override
    public void requstSuccess(T success) {
        view.loadDataSuccess(success);
    }

    @Override
    public void requstErorr(Throwable throwable) {
        view.loadDataError(throwable);
        view.disimissProgress();
    }

    @Override
    public void requestComplete() {
        view.disimissProgress();
    }
}
