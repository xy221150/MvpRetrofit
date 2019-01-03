package com.example.edz.mvpretrofit.Mvp.Presenter;

import com.example.edz.mvpretrofit.Base.BasePrsenter;
import com.example.edz.mvpretrofit.Bean.TestBean;
import com.example.edz.mvpretrofit.Mvp.Model.TestModel;
import com.example.edz.mvpretrofit.Mvp.View.TestView;

public class TestPresenter extends BasePrsenter<TestView,TestBean> implements IPresenter.TestPrsenter {
    TestModel model;

    public TestPresenter(TestView view) {
        attrchView(view);
        model=new TestModel();
    }

    @Override
    public void loadData(String name) {
        model.loadData(name,this);
    }
}
