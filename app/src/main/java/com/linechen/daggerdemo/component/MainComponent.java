package com.linechen.daggerdemo.component;

import com.linechen.daggerdemo.MainActivity;
import com.linechen.daggerdemo.module.MainModule;

import dagger.Component;

/**
 * Created by LineChen on 2017/8/22.
 */

@Component(modules = MainModule.class)
public interface MainComponent {
    void inject(MainActivity activity);
}
