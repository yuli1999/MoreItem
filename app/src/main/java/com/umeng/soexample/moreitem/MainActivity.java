package com.umeng.soexample.moreitem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.umeng.soexample.moreitem.Bean.BannBean;
import com.umeng.soexample.moreitem.adapter.HomeAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mHomeRe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        HomeAdapter adapter = new HomeAdapter(this);
        mHomeRe.setAdapter(adapter);
        mHomeRe.setLayoutManager(manager);

    }

    private void initView() {
        mHomeRe = findViewById(R.id.home_re);
    }
}
