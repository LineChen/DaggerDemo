package com.linechen.daggerdemo.module;

import com.linechen.daggerdemo.view.MainView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by LineChen on 2017/8/22.
 */

@Module
public class MainModule {
    private MainView view;

    public MainModule(MainView view) {
        this.view = view;
    }

    @Provides
    MainView provideMainView(){
        return view;
    }
}
