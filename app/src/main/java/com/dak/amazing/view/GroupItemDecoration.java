package com.dak.amazing.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.dak.amazing.adapter.CurrencyAdapter;
import com.dak.amazing.model.GroupContent;
import com.dak.amazing.model.GroupDataItem;

import java.util.Map;

/**
 * 分类RecycleView的分割线
 * Created by runTop on 2017/10/16.
 */
public class GroupItemDecoration extends RecyclerView.ItemDecoration {

    //文字画笔
    private Paint paintText;
    //北京画笔
    private Paint paintBg;
    //字体大小
    private int textSize = 20;
    //普通分割线高度
    private int decorationHeight = 5;
    //分组项高度
    private int decorationContentHeight = 40;
    //分组项字典以key-val形势存储，key为组内的第一个子View所在数据集的位置，val为分组项实体类。
    private Map<Integer, GroupContent> groupList;
    private int headPadding = (decorationContentHeight - textSize) / 2;

    public GroupItemDecoration(Map<Integer, GroupContent> groupList) {
        this.groupList = groupList;
        paintText = new Paint();
        paintText.setColor(Color.BLACK);
        paintText.setTextSize(textSize);
        paintText.setFlags(Paint.ANTI_ALIAS_FLAG);
        paintBg = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintBg.setColor(Color.GREEN);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        //获取当前子View在整个数据集中的位置
        int childrenPosition = parent.getChildLayoutPosition(view);
        //判断当前子View是否需要添加分组项
        if (groupList.get(childrenPosition) != null) {
            outRect.set(0, decorationContentHeight, 0, 0);
        } else {
            //如果是数据集最后一个item，则设置列表底部分割线
            if (parent.getAdapter().getItemCount() - 1 == childrenPosition) {
                outRect.set(0, decorationHeight, 0, decorationHeight);
            } else {
                outRect.set(0, decorationHeight, 0, 0);
            }
        }
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {

        int childCount = parent.getChildCount();
        //遍历RecycleView内的子View并画分割线和分组标题内容
        for (int i = 0; i < childCount; i++) {
            //通过parent.getChildAt(i)获取子View，然后通过子View获取它在数据集合中的位置，
            // 然后在通过这个位置获取分组列表项。
            GroupContent groupContent = groupList.get(parent.getChildLayoutPosition(parent.getChildAt(i)));
            //画分组标题内容
            if (groupContent != null) {
                View viewChild = parent.getChildAt(i);
                float y = viewChild.getY();
                //计算标题位置，使居中。
                y = y - headPadding;
                c.drawText(groupContent.getTitle(), headPadding, y, paintText);
            }
        }
        /**
         * 以下是绘制顶部浮层的内容。
         *  效果：当列表滑动时浮层会一直显示在屏幕的顶端，当下一组的标题滑动到顶端的时，会把第一个标题顶出屏幕，第二个标题继续悬浮在顶部。
         *  原理：当列表滑动时判断列表第一个组的最后一个子View底部坐标和浮层底部坐标重合时，设置浮层和组内的最后一个子View的底部坐标相同
         *        这样当列表滑动的时候浮层就会随着组内的最后一个View滑出屏幕外，当第二组的第一个子View成为RecycleVBiew显示的第一个View时
         *        会重新绘制默认的顶部浮层样式。
         */
        //获取RecycleView中显示的第一个子View。
        View firstView = parent.getChildAt(0);
        //根据显示的第一个子View获取它在数据集中的位置
        int firstItemPosition = parent.getChildLayoutPosition(firstView);
        CurrencyAdapter<GroupDataItem> adapter = (CurrencyAdapter) parent.getAdapter();
        //获取第一个子View所绑定的数据项
        GroupDataItem childrenData = adapter.getItemByPosition(firstItemPosition);
        //顶部浮层文字Y的位置
        int headTextY = 0;
        //顶部浮层y位置
        int headRectY = 0;
        //假如只有一个子View说明只有一组则不需要绘制浮层，只有子View大于一个的时候可能会有两组，这个时候需要绘制浮层。
        if (adapter.getItemCount() > 1) {
            //获取第二个子View所绑定的数据
            GroupDataItem childrenDataNext = adapter.getItemByPosition(firstItemPosition + 1);
            //显示的第一个子View的底部坐标
            int firstViewBottom = firstView.getBottom();
            //说明RecycleView中显示的第一个子View是这一组内最后一个itemView，在列表滑动时当这一组内最后一个子View（也是RecycleView中显示的第一个子View）
            // 的底部与浮层的底部重合的时候则让浮层的底部坐标一直等于最后一个子View的底部坐标，这样浮层就会随着滑动同最后一个子View一起滑出屏幕。
            if (childrenDataNext.getGroupId() != childrenData.getGroupId() && firstViewBottom <= decorationContentHeight) {
                headRectY = firstViewBottom;
                headTextY = firstViewBottom - headPadding;
            } else {//假如不是这一组内的最后一个子View或者组内最后一个子View的底部还没有和浮层的底部重合，则浮层的位置按正常绘制
                headRectY = decorationContentHeight;
                headTextY = decorationContentHeight - headPadding;
            }
            //浮层上需要显示的内容项
            GroupContent groupHeadContent = null;
            //只有当浮层完全移出屏幕时才会显示下一个分组的内容
            if (headRectY <= 0) {
                groupHeadContent = groupList.get(childrenDataNext.getGroupId());
            } else {
                groupHeadContent = groupList.get(childrenData.getGroupId());
            }
            c.drawRect(0, 0, parent.getRight(), headRectY, paintBg);
            c.drawText(groupHeadContent.getTitle(), headPadding, headTextY, paintText);
        }
    }

}
