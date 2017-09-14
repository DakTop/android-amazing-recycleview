package com.dak.amazing.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.dak.amazing.MainActivity;
import com.dak.amazing.R;
import com.dak.amazing.adapter.SwichLayoutAdapter;

/**
 * 布局转换的RecycleView
 */
public class SwitchLayoutActivity extends AppCompatActivity {
    private SwichLayoutAdapter adapter;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_layout);
        recyclerView = (RecyclerView) findViewById(R.id.recycle_switchlayout);
        //设置RecycleView的布局管理器
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new SwichLayoutAdapter(this, MainActivity.listData);
        recyclerView.setAdapter(adapter);
    }

    public void switchToGrid(View view) {
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        adapter.setRecycleviewState(true);
    }

    public void switchToLinear(View view) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setRecycleviewState(false);
    }

}
