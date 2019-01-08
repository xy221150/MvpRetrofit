package com.example.edz.mvpretrofit.Ui.Activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.edz.mvpretrofit.Base.BaseMvpActivity;
import com.example.edz.mvpretrofit.Bean.TestBean;
import com.example.edz.mvpretrofit.Mvp.Presenter.IPresenter;
import com.example.edz.mvpretrofit.Mvp.Presenter.TestPresenter;
import com.example.edz.mvpretrofit.Mvp.View.TestView;
import com.example.edz.mvpretrofit.R;
import com.example.edz.mvpretrofit.Utils.DialogUtils;

public class MainActivity extends BaseMvpActivity<TestPresenter,TestBean> implements TestView {
    Button button;
    TextView text;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        super.initView();
        button=findViewById(R.id.button);
        text=findViewById(R.id.text);
    }

    @Override
    protected TestPresenter initPrsenter() {
        return new TestPresenter(this);
    }

    @Override
    protected void attrPrsenter(final TestPresenter prsenter) {
        super.attrPrsenter(prsenter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prsenter.loadData("杭州");
            }
        });
    }



    @Override
    public void showProgress() {
        DialogUtils.showProgressDialog(this);
    }

    @Override
    public void disimissProgress() {
        DialogUtils.DismssProgressDialog();
        showToast("加载完成");
    }

    @Override
    public void loadDataSuccess(TestBean data) {
        text.setText(data.getResult().get(0).getTitle());
    }

    @Override
    public void loadDataError(Throwable throwable) {
        Toast.makeText(this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }

}
