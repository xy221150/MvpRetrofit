package com.example.edz.mvpretrofit.Ui.Activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.edz.mvpretrofit.Bean.TestBean;
import com.example.edz.mvpretrofit.Mvp.Presenter.TestPresenter;
import com.example.edz.mvpretrofit.Mvp.View.TestView;
import com.example.edz.mvpretrofit.R;

public class MainActivity extends AppCompatActivity implements TestView {
    Button button;
    TextView text;
    ProgressDialog progressDialog;
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
                presenter.loadData("杭州");
            }
        });
    }


    @Override
    public void showProgress() {
        if (progressDialog==null)
        {
            progressDialog=new ProgressDialog(this).show(this,"","正在加载",true,false);
            return;
        }
        else
        {
            progressDialog.setTitle("");
            progressDialog.setMessage("正在加载");
            progressDialog.show();
            return;
        }
    }

    @Override
    public void disimissProgress() {
        if (progressDialog!=null&&progressDialog.isShowing())
            progressDialog.dismiss();

        Toast.makeText(this, "加载完成", Toast.LENGTH_SHORT).show();
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
