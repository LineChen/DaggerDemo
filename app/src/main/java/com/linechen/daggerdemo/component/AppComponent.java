package com.linechen.daggerdemo.component;

import com.linechen.daggerdemo.MyApplication;
import com.linechen.daggerdemo.module.AppModule;

import dagger.Component;

/**
 * Created by LineChen on 2017/8/24.
 */

@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(MyApplication application);
}
