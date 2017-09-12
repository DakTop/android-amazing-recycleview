package com.dak.amazing.listener;

import android.view.View;

/**
 * RecycleView子view的点击事件
 * Created by runTop on 2017/9/12.
 */
public interface OnRecycleItemClickListener<T> {
    void onRecycleItemClick(View v, T t, int position);
}
