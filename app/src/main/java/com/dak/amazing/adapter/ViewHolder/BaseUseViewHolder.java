package com.dak.amazing.adapter.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.dak.amazing.R;

/**
 * 基本使用中ViewHolder
 * Created by runTop on 2017/9/11.
 */
public class BaseUseViewHolder extends RecyclerView.ViewHolder {
    public TextView textView;

    public BaseUseViewHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.textview);
    }
}
