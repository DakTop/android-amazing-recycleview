package com.dak.amazing.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;

/**
 * 通用Adapter使用的ViewHolder
 * Created by runTop on 2017/9/12.
 */
public class CurrencyViewHolder extends RecyclerView.ViewHolder {
    private SparseArray<View> mViews;
    private View mConvertView;

    public CurrencyViewHolder(View itemView) {
        super(itemView);
        mViews = new SparseArray<View>();
        mConvertView = itemView;
    }

    /**
     * 通过viewId获取控件
     *
     * @param viewId
     * @return
     */
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    /**
     * 设置TextView的值
     *
     * @param viewId
     * @param text
     * @return
     */
    public CurrencyViewHolder setText(int viewId, String text) {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

}
