package com.dak.amazing.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.dak.amazing.MainActivity;
import com.dak.amazing.R;
import com.dak.amazing.adapter.CurrencyAdapter;
import com.dak.amazing.adapter.ViewHolder.CurrencyViewHolder;
import com.dak.amazing.listener.OnRecycleItemClickListener;
import com.dak.amazing.model.DataItem;

/**
 * 布局转换的RecycleView
 */
public class SwitchLayoutActivity extends AppCompatActivity implements OnRecycleItemClickListener<DataItem> {
    private CurrencyAdapter<DataItem> adapter;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_layout);
        recyclerView = (RecyclerView) findViewById(R.id.recycle_switchlayout);
        //设置RecycleView的布局管理器
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CurrencyAdapter<DataItem>(this, R.layout.layout_linear_holder_item) {
            @Override
            public void onBindView(CurrencyViewHolder holder, DataItem dataItem, int position) {
                holder.setText(R.id.textview, dataItem.getText());
            }
        };
        adapter.setOnRecycleItemClickListener(this);
        recyclerView.setAdapter(adapter);
        adapter.refreshData(MainActivity.listData);
    }

    @Override
    public void onRecycleItemClick(View v, DataItem dataItem, int position) {
        Toast.makeText(this, "点击了：" + dataItem.getText(), Toast.LENGTH_SHORT).show();
    }


    public void switchToGrid(View view) {
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
    }

    public void switchToLinear(View view) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}
