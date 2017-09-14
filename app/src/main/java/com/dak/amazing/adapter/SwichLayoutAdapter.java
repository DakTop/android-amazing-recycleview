package com.dak.amazing.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.dak.amazing.R;
import com.dak.amazing.adapter.ViewHolder.CurrencyViewHolder;
import com.dak.amazing.model.DataItem;

import java.util.List;

/**
 * 布局转换adpter
 * Created by runTop on 2017/9/14.
 */
public class SwichLayoutAdapter extends RecyclerView.Adapter<CurrencyViewHolder> {

    //RecycleView列表状态
    public static final int RECYCLEVIEW_STATE_LINEAR = 0;
    //RecycleView网格状态
    public static final int RECYCLEVIEW_STATE_GRID = 1;
    //RecycleView状态
    private int RECYCLEVIEW_STATE = RECYCLEVIEW_STATE_LINEAR;

    private Context context;
    private List<DataItem> list;

    public SwichLayoutAdapter(Context mContext, List<DataItem> mlist) {
        context = mContext;
        list = mlist;
    }

    //这个方法一定要使用，根据这个返回值在onCreateViewHolder方法中判断布局类型
    @Override
    public int getItemViewType(int position) {
        return RECYCLEVIEW_STATE;
    }


    @Override
    public CurrencyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //列表状态
        if (RECYCLEVIEW_STATE == RECYCLEVIEW_STATE_LINEAR) {
            return new CurrencyViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_linear_holder_item, parent, false));
        } else {//RecycleView网格状态
            return new CurrencyViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_grid_holder_item, parent, false));
        }
    }

    /**
     * 不同的布局根据状态设置不同的数据
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(CurrencyViewHolder holder, int position) {
        DataItem dataItem = list.get(position);
        //列表状态
        if (RECYCLEVIEW_STATE == RECYCLEVIEW_STATE_LINEAR) {
            holder.setText(R.id.textview, dataItem.getText());
        } else {//RecycleView网格状态
            holder.setText(R.id.textview_grid, dataItem.getText());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    /**
     * 设置adapter状态
     *
     * @param toGrid
     */
    public void setRecycleviewState(boolean toGrid) {
        if (toGrid) {
            RECYCLEVIEW_STATE = RECYCLEVIEW_STATE_GRID;
        } else {
            RECYCLEVIEW_STATE = RECYCLEVIEW_STATE_LINEAR;
        }
        this.notifyDataSetChanged();
    }
}
