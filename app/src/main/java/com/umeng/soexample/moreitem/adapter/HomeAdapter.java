package com.umeng.soexample.moreitem.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.umeng.soexample.moreitem.Bean.BannBean;
import com.umeng.soexample.moreitem.Bean.ReOneBean;
import com.umeng.soexample.moreitem.R;
import com.umeng.soexample.moreitem.mvp.presenter.HomePresenter;
import com.umeng.soexample.moreitem.mvp.view.HomeView;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * data:2018/12/9
 * author: HJL (磊)
 * function:
 */
public class HomeAdapter extends RecyclerView.Adapter implements HomeView {

    private Context context;


    public HomeAdapter(Context context) {
        this.context = context;

    }

    private MyViewHolder_Bann myViewHolder_bann;

    private HomePresenter presenter = new HomePresenter(this);

    private List<BannBean.ResultBean> bannlist = new ArrayList<>();
    private List<ReOneBean.ResultBean.RxxpBean.CommodityListBean> reonelist = new ArrayList<>();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view = View.inflate(context, R.layout.bann_item, null);
            myViewHolder_bann = new MyViewHolder_Bann(view);
            return myViewHolder_bann;
        } else {
            return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder_Bann) {
            presenter.bann();
        }
    }

    @Override
    public int getItemViewType(int position) {

        return position;
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    //轮播图
    @Override
    public void bann(List data) {
        bannlist.addAll(data);
        final BannAdapter adapter = new BannAdapter(context, bannlist);
        myViewHolder_bann.mbanner.setPages(bannlist, new MZHolderCreator() {
            @Override
            public MZViewHolder createViewHolder() {
                return adapter;
            }
        });


    }

    //第一个
    @Override
    public void reone(List data) {

    }

    @Override
    public void onFaile(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }


    //轮播图
    class MyViewHolder_Bann extends RecyclerView.ViewHolder {

        MZBannerView mbanner;


        public MyViewHolder_Bann(View itemView) {
            super(itemView);
            mbanner = itemView.findViewById(R.id.banner);

        }

    }

    //第一个
    class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(View itemView) {
            super(itemView);

        }
    }


}
