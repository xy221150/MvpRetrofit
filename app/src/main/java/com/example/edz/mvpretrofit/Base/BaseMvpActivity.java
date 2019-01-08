package com.example.edz.mvpretrofit.Base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public abstract class BaseMvpActivity<P extends BasePrsenter,T> extends AppCompatActivity implements BaseView<T> {
    P prsenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        initView();
        init();
        prsenter=initPrsenter();
        prsenter.attrchView(this);
        attrPrsenter(prsenter);
        initDate();
    }
    protected abstract P initPrsenter();

    protected abstract int getLayoutID();

    protected  void initView(){

    }

    protected  void init(){}

    protected void initDate(){}

    protected void attrPrsenter(P prsenter){}

    public void showToast(String string)
    {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }

    public void StartActivity(Class<? extends Activity> cls)
    {
        Intent intent=new Intent(this,cls);
        startActivity(intent);
    }

    public void StartActivityResult(Class<? extends Activity> cls,int i)
    {
        Intent intent=new Intent(this,cls);
        startActivityForResult(intent,i);
    }
    @Override
    public void showProgress() {

    }

    @Override
    public void disimissProgress() {

    }

    @Override
    public void loadDataSuccess(T data) {

    }

    @Override
    public void loadDataError(Throwable throwable) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        prsenter.onDestroy();
    }
}
