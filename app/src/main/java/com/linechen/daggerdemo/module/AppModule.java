package com.linechen.daggerdemo.module;

import com.linechen.daggerdemo.implementation.IAppView1Ipl;
import com.linechen.daggerdemo.view.IAppView1;

import dagger.Module;
import dagger.Provides;

/**
 * Created by LineChen on 2017/8/24.
 */

@Module
public class AppModule {


    @Provides
    IAppView1 provideIAppView1(){
        return new IAppView1Ipl();
    }
}
