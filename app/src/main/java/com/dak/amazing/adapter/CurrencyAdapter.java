package com.dak.amazing.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dak.amazing.listener.OnRecycleItemClickListener;
import com.dak.amazing.tools.Tools;

import java.util.ArrayList;
import java.util.List;

/**
 * 通用的Adapter
 * Created by runTop on 2017/9/12.
 */
public abstract class CurrencyAdapter<T> extends RecyclerView.Adapter<CurrencyViewHolder> {
    private List<T> listData = new ArrayList<>();
    private OnRecycleItemClickListener<T> onRecycleItemClickListener;
    private int mItemLayoutId;
    private Context mContext;

    public CurrencyAdapter(Context context, int itemLayoutId) {
        mItemLayoutId = itemLayoutId;
        mContext = context;
    }

    @Override
    public CurrencyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(mItemLayoutId, parent, false);
        CurrencyViewHolder currencyViewHolder = new CurrencyViewHolder(view);
        setItemViewListener(viewType, currencyViewHolder, view);
        return currencyViewHolder;
    }

    @Override
    public void onBindViewHolder(CurrencyViewHolder holder, int position) {
        onBindView(holder, listData.get(position), position);
    }

    /**
     * 外部初始化Adapter或者继承此Adapter时必须实现这个方法，这个方法主要处理列表上item显示的逻辑
     *
     * @param holder
     * @param t        item上绑定的数据项
     * @param position item的位置
     */
    public abstract void onBindView(CurrencyViewHolder holder, T t, int position);

    @Override
    public int getItemCount() {
        return listData.size();
    }

    /**
     * 刷新列表页
     *
     * @param list
     */
    public void refreshData(List<T> list) {
        listData.clear();
        if (!Tools.isEmptyList(list))
            listData.addAll(list);
        this.notifyDataSetChanged();
    }

    /**
     * 加载新的列表数据
     *
     * @param list
     */
    public void loadMoreData(List<T> list) {
        if (Tools.isEmptyList(list))
            return;
        listData.addAll(list);
        this.notifyDataSetChanged();
    }

    /**
     * 设置itemView项监听
     *
     * @param viewHolderType ViewHolder的类型，可以通过判断类型设置不同的点击效果
     * @param viewHolder
     * @param view
     */
    private void setItemViewListener(int viewHolderType, final RecyclerView.ViewHolder viewHolder, View view) {

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //通过ViewHolder获取它在列表的位置
                int position = viewHolder.getAdapterPosition();
                if (onRecycleItemClickListener != null) {
                    onRecycleItemClickListener.onRecycleItemClick(v, listData.get(position), position);
                }
            }
        });
    }

    /**
     * 设置itemView的点击事件
     *
     * @param onRecycleItemClickListener
     */
    public void setOnRecycleItemClickListener(OnRecycleItemClickListener onRecycleItemClickListener) {
        this.onRecycleItemClickListener = onRecycleItemClickListener;
    }
}
