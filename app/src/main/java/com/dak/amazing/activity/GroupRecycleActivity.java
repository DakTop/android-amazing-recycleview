package com.dak.amazing.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dak.amazing.R;
import com.dak.amazing.adapter.CurrencyAdapter;
import com.dak.amazing.adapter.ViewHolder.CurrencyViewHolder;
import com.dak.amazing.model.GroupContent;
import com.dak.amazing.model.GroupDataItem;
import com.dak.amazing.view.GroupItemDecoration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * item分类列表
 */
public class GroupRecycleActivity extends AppCompatActivity {
    private RecyclerView recycleGroup;
    private CurrencyAdapter<GroupDataItem> adapter;
    private Map<Integer, GroupContent> groupList = new HashMap<>();
    private List<GroupDataItem> groupDataItemsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_layout);
        recycleGroup = (RecyclerView) findViewById(R.id.recycle_group_layout);
        recycleGroup.setLayoutManager(new LinearLayoutManager(this));

        for (int i = 0; i < 25; i++) {
            if (i < 5) {
                groupDataItemsList.add(new GroupDataItem("item" + i, 0));
            } else if (i < 8) {
                groupDataItemsList.add(new GroupDataItem("item" + i, 5));
            } else if (i < 13) {
                groupDataItemsList.add(new GroupDataItem("item" + i, 8));
            } else if (i < 19) {
                groupDataItemsList.add(new GroupDataItem("item" + i, 13));
            } else {
                groupDataItemsList.add(new GroupDataItem("item" + i, 13));
            }
        }
        groupList.put(0, new GroupContent("服装"));
        groupList.put(5, new GroupContent("玩具"));
        groupList.put(8, new GroupContent("出行"));
        groupList.put(13, new GroupContent("家居"));
        groupList.put(19, new GroupContent("办公"));

        recycleGroup.addItemDecoration(new GroupItemDecoration(groupList));
        adapter = new CurrencyAdapter<GroupDataItem>(this, R.layout.layout_linear_holder_item) {
            @Override
            public void onBindView(CurrencyViewHolder holder, GroupDataItem dataItem, int position) {
                holder.setText(R.id.textview, dataItem.getText());
            }
        };
        recycleGroup.setAdapter(adapter);
        adapter.refreshData(groupDataItemsList);
    }
}
