package com.dak.amazing.model;

/**
 * 分组列表项
 * Created by runTop on 2017/10/18.
 */
public class GroupDataItem extends DataItem {
    private int groupId;

    public GroupDataItem(String text, int groupId) {
        super(text);
        this.groupId = groupId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
}
