package tech.thdev.androidrecyclerview.data;

import android.support.annotation.DrawableRes;

import tech.thdev.support.widget.data.BaseItem;

/**
 * Created by Tae-hwan on 18/10/2016.
 */

public class LocalImage implements BaseItem {

    @DrawableRes
    private int resource;
    private String title;
    private String date;
    private int viewType;

    public LocalImage(int resource, String title, String date, int viewType) {
        this.resource = resource;
        this.title = title;
        this.date = date;
        this.viewType = viewType;
    }

    @Override
    public int getViewType() {
        return viewType;
    }

    public int getResource() {
        return resource;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }
}
