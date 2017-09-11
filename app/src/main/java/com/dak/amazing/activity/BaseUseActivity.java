package com.dak.amazing.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dak.amazing.MainActivity;
import com.dak.amazing.R;
import com.dak.amazing.adapter.BaseUseRecycleViewAdapter;

/**
 * RecycleView最基本的使用
 */
public class BaseUseActivity extends AppCompatActivity {
    private BaseUseRecycleViewAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_use);
        recyclerView = (RecyclerView) findViewById(R.id.recycle_baseuse);
        //设置RecycleView的布局管理器
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new BaseUseRecycleViewAdapter(this);
        recyclerView.setAdapter(adapter);
        adapter.notifyData(MainActivity.listData);
    }
}
