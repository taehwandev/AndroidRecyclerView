package tech.thdev.androidrecyclerview.ui.basic.mvp.adapter;

import android.view.ViewGroup;

import tech.thdev.androidrecyclerview.ui.basic.mvp.adapter.holder.BasicMVPViewHolder;
import tech.thdev.support.widget.adapter.simple.BaseSimpleRecyclerAdapter;
import tech.thdev.support.widget.adapter.simple.holder.BaseViewHolder;

/**
 * Created by Tae-hwan on 10/10/2016.
 */

public class BasicMVPAdapter
        extends BaseSimpleRecyclerAdapter<String> {

    public BasicMVPAdapter() {
        super();
    }

    @Override
    public BaseViewHolder<String> onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BasicMVPViewHolder(parent, this);
    }

    @Override
    public int onItemViewType(int position) {
        return 0;
    }
}
