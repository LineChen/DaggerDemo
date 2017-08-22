package com.linechen.daggerdemo.presenter;

import com.linechen.daggerdemo.view.MainView;

import javax.inject.Inject;

/**
 * Created by LineChen on 2017/8/22.
 */

public class MainPresenter {

    private MainView view;

    @Inject
    public MainPresenter(MainView view) {
        this.view = view;
    }

    public void load(){
        view.onLoaded((int) System.currentTimeMillis());
    }
}
