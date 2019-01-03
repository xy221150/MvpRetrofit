package com.example.edz.mvpretrofit.Mvp.Model;

import android.util.Log;

import com.example.edz.mvpretrofit.Bean.TestBean;
import com.example.edz.mvpretrofit.Network.RetrofitCallBack;
import com.example.edz.mvpretrofit.Network.RetrofitHelper;
import com.example.edz.mvpretrofit.Network.api.Api;


import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;


public class TestModel implements IModel.BaseModel<TestBean> {
    Api api;
    public TestModel(){
        api=RetrofitHelper.create(Api.class);
    }
    @Override
    public void loadData(String name, final RetrofitCallBack<TestBean> callBack) {
        api.post(name)
                 .subscribeOn(io.reactivex.schedulers.Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(new Observer<TestBean>() {
                     @Override
                     public void onSubscribe(Disposable d) {
                         callBack.beforeRequest();
                         Log.d("TAG", "onSubscribe: "+d.toString());
                     }

                     @Override
                     public void onNext(TestBean testBean) {
                          callBack.requstSuccess(testBean);
                         Log.d("TAG", "onNext: "+testBean.getMessage());
                     }

                     @Override
                     public void onError(Throwable e) {
                         callBack.requstErorr(e);
                         Log.d("TAG", "onError: "+e.getMessage());
                     }

                     @Override
                     public void onComplete() {
                         callBack.requestComplete();
                         Log.d("TAG", "onComplete: ");
                     }
                 });
    }
}
