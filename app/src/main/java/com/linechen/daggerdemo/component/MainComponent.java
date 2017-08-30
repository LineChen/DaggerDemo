package com.linechen.daggerdemo.component;

import com.linechen.daggerdemo.MainActivity;
import com.linechen.daggerdemo.module.AppModule;
import com.linechen.daggerdemo.module.MainModule;

import dagger.Component;

/**
 * Created by LineChen on 2017/8/22.
 */

/**
 * 1->dependencies ：A list of types that are to be used as <a href="#component-dependencies">component
 */
@Component(dependencies = AppComponent.class, modules = {MainModule.class, AppModule.class})
public interface MainComponent {
    void inject(MainActivity activity);
}
