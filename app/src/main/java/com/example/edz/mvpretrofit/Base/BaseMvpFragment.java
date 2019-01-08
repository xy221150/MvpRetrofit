package com.example.edz.mvpretrofit.Base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseMvpFragment<P extends BasePrsenter,T> extends Fragment implements BaseView {
    private View view;
    private P prsenter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view=inflater.inflate(getLayoutID(),null);
         initView(view);
         init();
         prsenter=getPrsenter();
         prsenter.attrchView(this);
         attrPrsenter(prsenter);
         initDate();
         return view;
    }

    protected abstract int getLayoutID();

    protected abstract P getPrsenter();

    protected void initView(View view) {}

    protected void attrPrsenter(P prsenter){}

    protected void init(){}

    protected void initDate(){}

    @Override
    public void showProgress() {

    }

    @Override
    public void disimissProgress() {

    }

    @Override
    public void loadDataSuccess(Object data) {

    }

    @Override
    public void loadDataError(Throwable throwable) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        prsenter.onDestroy();
    }
}
