package com.umeng.soexample.moreitem.mvp.presenter;

import com.umeng.soexample.moreitem.mvp.HomeCallBack;
import com.umeng.soexample.moreitem.mvp.model.HomeModel;
import com.umeng.soexample.moreitem.mvp.view.HomeView;

import java.util.List;

/**
 * data:2018/12/9
 * author: HJL (磊)
 * function:
 */
public class HomePresenter {

    private HomeView homeView;
    private HomeModel homeModel;

    public HomePresenter(HomeView homeView) {
        this.homeView = homeView;
        homeModel = new HomeModel();
    }


    public void bann() {
        homeModel.bann(new HomeCallBack() {
            @Override
            public void onSuccess(List data) {
                homeView.bann(data);
            }

            @Override
            public void onFaile(String msg) {
                homeView.onFaile(msg);
            }
        });
    }

    public void reone() {
        homeModel.reone(new HomeCallBack() {
            @Override
            public void onSuccess(List data) {
                homeView.reone(data);
            }

            @Override
            public void onFaile(String msg) {
                homeView.onFaile(msg);
            }
        });
    }
}
