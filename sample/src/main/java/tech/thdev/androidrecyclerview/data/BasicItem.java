package tech.thdev.androidrecyclerview.data;

import tech.thdev.support.widget.data.BaseItem;

/**
 * Created by Tae-hwan on 10/10/2016.
 */

public class BasicItem implements BaseItem {
    public String name;
    private int viewType;

    public BasicItem(String name, int viewType) {
        this.name = name;
        this.viewType = viewType;
    }

    @Override
    public int getViewType() {
        return viewType;
    }
}