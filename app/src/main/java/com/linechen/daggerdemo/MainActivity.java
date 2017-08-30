package com.linechen.daggerdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.linechen.daggerdemo.component.DaggerMainComponent;
import com.linechen.daggerdemo.module.MainModule;
import com.linechen.daggerdemo.presenter.MainPresenter;
import com.linechen.daggerdemo.view.IMainView2;
import com.linechen.daggerdemo.view.MainView;
import com.orhanobut.logger.Logger;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainView{

    @Inject
    MainPresenter presenter;//这里不能加private 修饰符，因为Error:(18, 27) 错误: Dagger does not support injection into private fields

//    @Inject
//    IAppView1 appView1;//从AppComponent中获取的

    @Inject
    IMainView2 mainView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //普通方式
//        presenter = new MainPresenter(this);

        //使用dagger2
        DaggerMainComponent.builder().appComponent(MyApplication.appComponent)
                .mainModule(new MainModule(this))
                .build().inject(this);

//        Logger.e("appView1" + appView1.getAppName());

        //在MainActivity中inject IAppView1时，下面这句会正确执行
        //如果不inject时，这行代码也会正确执行，因为DaggerMainComponent 中有MyApplication.appComponent的创建
        Logger.e("mainView2：" + mainView2.getAppName());
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
