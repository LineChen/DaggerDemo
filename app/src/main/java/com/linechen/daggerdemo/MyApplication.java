package com.linechen.daggerdemo;

import android.app.Application;

import com.linechen.daggerdemo.component.AppComponent;
import com.linechen.daggerdemo.component.DaggerAppComponent;
import com.linechen.daggerdemo.module.AppModule;
import com.linechen.daggerdemo.view.IAppView1;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import okhttp3.OkHttpClient;

/**
 * Created by LineChen on 2017/8/23.
 */

public class MyApplication extends Application{

    public static final String TAG = "MyApplication";

    @Inject
    IAppView1 appView1;

    public static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        Logger.addLogAdapter(new AndroidLogAdapter());

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(new LoggerInterceptor("TAG"))
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                //其他配置
                .build();
        OkHttpUtils.initClient(okHttpClient);

        appComponent = DaggerAppComponent.builder().appModule(new AppModule()).build();
        appComponent.inject(this);

        Logger.d(appView1.getAppName());

    }



}
