package com.dak.amazing.view;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * 分割线
 * Created by runTop on 2017/9/13.
 */
public class RecycleViewItemDecoration extends RecyclerView.ItemDecoration {

    /**
     * 代替了onDraw(Canvas c, RecyclerView parent)方法。
     * <p>
     * 在画布c上画任何内容。这个方法在RecycleView的item绘制之前调用，
     * 所以他绘制的内容会在RecycleView的itemView的下一层。
     *
     * @param c
     * @param parent
     * @param state
     */
    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
    }

    /**
     * 代替了onDrawOver(Canvas c, RecyclerView parent)方法。
     * 在画布c上画任何内容。这个方法在RecycleView的item绘制之后调用，
     * 所以他绘制的内容会在RecycleView的itemView的上一层。
     *
     * @param c
     * @param parent
     * @param state
     */
    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
    }


    /**
     * 代替了getItemOffsets(Rect outRect, int itemPosition, RecyclerView parent)方法。
     *
     * @param outRect
     * @param view
     * @param parent
     * @param state
     */
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
    }

}
