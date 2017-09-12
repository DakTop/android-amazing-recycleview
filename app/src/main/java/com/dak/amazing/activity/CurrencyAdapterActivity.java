package com.dak.amazing.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.dak.amazing.MainActivity;
import com.dak.amazing.R;
import com.dak.amazing.adapter.CurrencyAdapter;
import com.dak.amazing.adapter.CurrencyViewHolder;
import com.dak.amazing.listener.OnRecycleItemClickListener;
import com.dak.amazing.model.DataItem;

/**
 * 展示一个通用的Adapter
 */
public class CurrencyAdapterActivity extends AppCompatActivity implements OnRecycleItemClickListener<DataItem> {

    private CurrencyAdapter<DataItem> adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_adapter);
        recyclerView = (RecyclerView) findViewById(R.id.recycle_currency);
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
    }

    @Override
    public void onRecycleItemClick(View v, DataItem dataItem, int position) {
        Toast.makeText(this, "点击了：" + dataItem.getText(), Toast.LENGTH_SHORT).show();
    }


    public void refreshData(View view) {
        adapter.refreshData(MainActivity.listData);
    }

    public void loadMore(View view) {
        adapter.loadMoreData(MainActivity.listData);
    }

}
