package com.dak.amazing.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.dak.amazing.MainActivity;
import com.dak.amazing.R;
import com.dak.amazing.adapter.BaseUseRecycleViewAdapter;
import com.dak.amazing.listener.OnRecycleItemClickListener;
import com.dak.amazing.model.DataItem;
import com.dak.amazing.view.RecycleViewItemDecoration;

/**
 * RecycleView最基本的使用
 */
public class BaseUseActivity extends AppCompatActivity implements OnRecycleItemClickListener<DataItem> {
    private BaseUseRecycleViewAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_use);
        recyclerView = (RecyclerView) findViewById(R.id.recycle_baseuse);
        //设置RecycleView的布局管理器
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new RecycleViewItemDecoration());
        adapter = new BaseUseRecycleViewAdapter(this);
        adapter.setOnRecycleItemClickListener(this);
        recyclerView.setAdapter(adapter);
        adapter.notifyData(MainActivity.listData);
    }

    @Override
    public void onRecycleItemClick(View v, DataItem dataItem, int position) {
        Toast.makeText(this, "点击了：" + dataItem.getText(), Toast.LENGTH_SHORT).show();
    }
}
