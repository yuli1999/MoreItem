package com.umeng.soexample.moreitem.mvp.model;

import android.os.Handler;

import com.google.gson.Gson;
import com.umeng.soexample.moreitem.Bean.BannBean;
import com.umeng.soexample.moreitem.Bean.ReOneBean;
import com.umeng.soexample.moreitem.mvp.HomeCallBack;
import com.umeng.soexample.moreitem.net.HttpNet;
import com.umeng.soexample.moreitem.net.Util;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * data:2018/12/9
 * author: HJL (磊)
 * function:
 */
public class HomeModel {
    private Handler handler = new Handler();


    //轮播图
    public void bann(final HomeCallBack callBack) {
        HttpNet.EnestenGet(Util.BANNER_URL, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callBack.onFaile("加载失败");
            }

            @Override
            public void onResponse(final Call call, Response response) throws IOException {
                String data = response.body().string();
                Gson gson = new Gson();
                BannBean bannBean = gson.fromJson(data, BannBean.class);
                final List<BannBean.ResultBean> result = bannBean.getResult();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onSuccess(result);
                    }
                });
            }
        });
    }

    //第一个条目
    public void reone(final HomeCallBack callBack) {
        HttpNet.EnestenGet(Util.HOME_URL, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callBack.onFaile("加载失败");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String data = response.body().string();
                Gson gson = new Gson();
                ReOneBean reOneBean = gson.fromJson(data, ReOneBean.class);
                final List<ReOneBean.ResultBean.RxxpBean.CommodityListBean> reone = reOneBean.getResult().getRxxp().get(0).getCommodityList();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onSuccess(reone);
                    }
                });
            }
        });
    }
    //第二个


}
