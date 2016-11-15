package tech.thdev.androidrecyclerview.view.basic.mvp.adapter;

import android.content.Context;
import android.view.ViewGroup;

import org.jetbrains.annotations.NotNull;

import tech.thdev.androidrecyclerview.view.basic.mvp.adapter.holder.BasicJavaViewHolder;
import tech.thdev.support.widget.adapter.simple.BaseSimpleRecyclerAdapter;
import tech.thdev.support.widget.adapter.simple.holder.BaseViewHolder;

/**
 * Created by Tae-hwan on 10/10/2016.
 */

public class BasicJavaAdapter
        extends BaseSimpleRecyclerAdapter<String> {

    public BasicJavaAdapter(@NotNull Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder<String> onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BasicJavaViewHolder(parent, this);
    }

    @Override
    public int onItemViewType(int position) {
        return 0;
    }
}
