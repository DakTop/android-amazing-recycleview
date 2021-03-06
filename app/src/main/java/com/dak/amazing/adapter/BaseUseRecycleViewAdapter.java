package com.dak.amazing.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dak.amazing.R;
import com.dak.amazing.adapter.ViewHolder.BaseUseViewHolder;
import com.dak.amazing.listener.OnRecycleItemClickListener;
import com.dak.amazing.model.DataItem;

import java.util.ArrayList;
import java.util.List;

/**
 * RecycleView基本使用的adapter
 * <p>
 * 1、首先Adapter会调用getItemCount()方法，RecycleView会询问adapter拥有列表包含多少个元素。
 * 2、RecycleView调用onCreateViewHolder()方法创建ViewHolder,以及ViewHolder管理的视图。
 * 3、最后RecycleView会传入ViewHolder及通过LayoutManager来确定其位置，并调用onBindViewHolder()方法绑定相应位置上的数据到ViewHolder。
 * <p>
 * 说明：这里并不是数据集合中有多少数据就会创建多少ViewHolder。RecycleView的复用机制就在这里：ViewHolder的创建数量就是你在有限的窗口内所展示itemView的最大数量。
 * 比如你的RecycleView设置的大小正好能展示5个itemVeiw，那么RecycleView只会创建5个ViewHolder（也就是说onCreateViewHolder()方法只会执行5次），
 * 当列表滚动时，滑出屏幕的ViewHolder会被回收，下面新滑进屏幕的item就是复用刚刚滑出屏幕的ViewHolder并且调用onBindViewHolder()方法重新绑定viewHolder的数据，
 * 这样就可以通过回收旧的ViewHolder来节省时间和内存。
 * <p>
 * Created by bazengliang on 2017/7/18.
 */
public class BaseUseRecycleViewAdapter extends RecyclerView.Adapter<BaseUseViewHolder> {

    private List<DataItem> listData = new ArrayList<>();
    private Context context;
    private OnRecycleItemClickListener<DataItem> onRecycleItemClickListener;

    public BaseUseRecycleViewAdapter(Context context) {
        this.context = context;
    }

    /**
     * 创建并返回一个相应类型的ViewHolder，每当调用完此方法，会立即调用onBindViewHolder()方法绑定数据，
     * 然后再次调用此方法创建下一个ViewHolder,然后继续调用onBindViewHolder()方法绑定数据，以此类推...
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public BaseUseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_linear_holder_item, parent, false);
        BaseUseViewHolder myViewHolder = new BaseUseViewHolder(view);
        //设置点击事件
        setItemViewListener(viewType, myViewHolder, view);
        return myViewHolder;
    }

    /**
     * 更新绑定的ViewHolder的布局
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(BaseUseViewHolder holder, int position) {
        holder.textView.setText(listData.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public void notifyData(List<DataItem> mlist) {
        listData.clear();
        listData.addAll(mlist);
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

