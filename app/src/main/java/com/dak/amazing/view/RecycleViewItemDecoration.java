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
     * 代替了onDraw(Canvas c, RecyclerView parent)方法。在RecycleView的onDraw()方法中调用。
     * <p>
     * 在画布c上画任何内容。这个方法在RecycleView的item绘制之前调用，
     * 所以他绘制的内容会在RecycleView的itemView的下一层。
     *
     * @param c RecycleView的画布
     * @param parent
     * @param state
     */
    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
    }

    /**
     * 代替了onDrawOver(Canvas c, RecyclerView parent)方法。在RecycleView的draw()方法中调用。
     * <p>
     * 在画布c上画任何内容。这个方法在RecycleView的item绘制之后调用，
     * 所以他绘制的内容会在RecycleView的itemView的上一层。
     *
     * @param c RecycleView的画布
     * @param parent
     * @param state
     */
    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
    }

    /**
     * 代替了getItemOffsets(Rect outRect, int itemPosition, RecyclerView parent)方法。
     * <p>
     * 在RecycleView调用measureChild方法测量子View的时候调用，每测量一个，就调用一次。
     * 在measureChild方法中会调用getItemDecorInsetsForChild方法，这个方法主要是将你设置的所有的
     * ItemDecoration中的Rect中的距离值叠加到一起返回给measureChild方法。然后RecycleView通过返回
     * 的这个rect中的的值来确定子View的大小。
     *
     * @param outRect
     * @param view RecycleView的子View
     * @param parent
     * @param state
     */
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
    }

}
