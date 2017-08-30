package com.linechen.daggerdemo.implementation;

import com.linechen.daggerdemo.view.IAppView1;

/**
 * Created by LineChen on 2017/8/24.
 */

public class IAppView1Ipl implements IAppView1 {
    @Override
    public String getAppName() {
        return "DaggerDemo";
    }
}
