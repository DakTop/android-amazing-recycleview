package com.dak.amazing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.dak.amazing.activity.BaseUseActivity;
import com.dak.amazing.model.DataItem;

import java.util.ArrayList;
import java.util.List;

/**
 * RecycleView的各种使用
 */
public class MainActivity extends AppCompatActivity {
    public static List<DataItem> listData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 0; i < 20; i++) {
            listData.add(new DataItem("item" + i));
        }
    }

    /**
     * 基本使用
     *
     * @param view
     */
    public void baseUse(View view) {
        this.startActivity(new Intent(this, BaseUseActivity.class));
    }

    /**
     * 布局样式切换，纵向列表布局与网格布局之间的切换
     *
     * @param view
     */
    public void layoutSwitch(View view) {

    }
}
