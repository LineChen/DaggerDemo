package com.linechen.daggerdemo.module;

import com.linechen.daggerdemo.view.IAppView1;
import com.linechen.daggerdemo.view.IMainView2;
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

    @Provides
    IMainView2 provideMainView2(IAppView1 appView1){
        return new IMainView2(appView1);
    }
}
