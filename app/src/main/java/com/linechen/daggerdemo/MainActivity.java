package com.linechen.daggerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.linechen.daggerdemo.component.DaggerMainComponent;
import com.linechen.daggerdemo.module.MainModule;
import com.linechen.daggerdemo.presenter.MainPresenter;
import com.linechen.daggerdemo.view.MainView;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainView{

    @Inject
    MainPresenter presenter;//这里不能加private 修饰符，因为Error:(18, 27) 错误: Dagger does not support injection into private fields

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //普通方式
//        presenter = new MainPresenter(this);

        //使用dagger2
        DaggerMainComponent.builder()
                .mainModule(new MainModule(this))
                .build().inject(this);

    }

    @Override
    public void onLoaded(int status) {
        if(status % 2 == 0){
            Toast.makeText(this, "load success", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "load failed", Toast.LENGTH_SHORT).show();
        }
    }

    public void load(View view) {
        presenter.load();
    }
}
