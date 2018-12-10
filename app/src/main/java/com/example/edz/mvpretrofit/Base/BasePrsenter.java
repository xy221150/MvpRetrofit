package com.example.edz.mvpretrofit.Base;


import com.example.edz.mvpretrofit.Network.RetrofitCallBack;


//V继承BaseView T接口bean
public class BasePrsenter<V extends BaseView,T>implements RetrofitCallBack<T> {
    BaseView baseView=null;

    public BasePrsenter(V baseView){
        this.baseView=baseView;
    }

    @Override
    public void beforeRequest() {
        baseView.showProgress();
    }

    @Override
    public void requstSuccess(T success) {
        baseView.loadDataSuccess(success);
    }

    @Override
    public void requstErorr(Throwable throwable) {
           baseView.loadDataError(throwable);
    }

    @Override
    public void requestComplete() {
          baseView.disimissProgress();
    }
}
