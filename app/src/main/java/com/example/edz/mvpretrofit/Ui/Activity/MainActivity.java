package com.example.edz.mvpretrofit.Ui.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.edz.mvpretrofit.Bean.TestBean;
import com.example.edz.mvpretrofit.Mvp.Presenter.TestPresenter;
import com.example.edz.mvpretrofit.Mvp.View.TestView;
import com.example.edz.mvpretrofit.R;

public class MainActivity extends AppCompatActivity implements TestView {
    Button button;
    TextView text;

    private TestPresenter presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        text=findViewById(R.id.text);
        presenter=new TestPresenter(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.loadData("盗墓笔记");
            }
        });
    }


    @Override
    public void showProgress() {

    }

    @Override
    public void disimissProgress() {

    }

    @Override
    public void loadDataSuccess(TestBean data) {
        text.setText(data.getData().get(0));
    }

    @Override
    public void loadDataError(Throwable throwable) {

    }
}
