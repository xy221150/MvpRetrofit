package com.example.edz.mvpretrofit.Mvp.Presenter;

import com.example.edz.mvpretrofit.Base.BasePrsenter;
import com.example.edz.mvpretrofit.Bean.TestBean;
import com.example.edz.mvpretrofit.Mvp.Model.TestModel;
import com.example.edz.mvpretrofit.Mvp.View.TestView;

import java.util.Map;

public class TestPresenter extends BasePrsenter<TestView,TestBean> implements TestPresenterlmp{
    TestModel model;

    public TestPresenter(TestView baseView) {
        super(baseView);
        model=new TestModel();
    }

    @Override
    public void loadData(String name) {
        model.loadData(name,this);
    }
}
