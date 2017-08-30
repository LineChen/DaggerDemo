package com.linechen.daggerdemo.view;

/**
 * Created by LineChen on 2017/8/24.
 */

public class IMainView2 {

    IAppView1 appView1;

    public IMainView2(IAppView1 appView1) {
        this.appView1 = appView1;
    }

    public String getAppName(){
        return appView1.getAppName();
    }
}
