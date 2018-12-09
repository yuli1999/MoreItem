package com.umeng.soexample.moreitem.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.umeng.soexample.moreitem.Bean.BannBean;
import com.umeng.soexample.moreitem.R;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import java.util.List;

/**
 * data:2018/12/9
 * author: HJL (磊)
 * function:
 */
public class BannAdapter implements MZViewHolder<BannBean.ResultBean> {

    private Context context;
    private List<BannBean.ResultBean> list;
    private SimpleDraweeView mbannpic;
    private TextView mbanntxt;

    public BannAdapter(Context context, List<BannBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public View createView(Context context) {
        View view = View.inflate(context, R.layout.bann_pic_item, null);
        mbannpic = view.findViewById(R.id.bann_pic);
        mbanntxt = view.findViewById(R.id.bann_txt);
        return view;
    }

    @Override
    public void onBind(Context context, int i, BannBean.ResultBean resultBean) {
        Uri parse = Uri.parse(list.get(i).getImageUrl());
        mbannpic.setImageURI(parse);
        mbanntxt.setText(list.get(i).getTitle());
    }

}
