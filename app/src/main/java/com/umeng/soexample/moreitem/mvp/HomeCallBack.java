package com.umeng.soexample.moreitem.mvp;

import java.util.List;

/**
 * data:2018/12/9
 * author: HJL (磊)
 * function:
 */
public interface HomeCallBack {
    void onSuccess(List data);

    void onFaile(String msg);
}
