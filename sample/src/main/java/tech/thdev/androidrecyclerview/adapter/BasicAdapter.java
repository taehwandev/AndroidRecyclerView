package tech.thdev.androidrecyclerview.adapter;

import android.content.Context;
import android.view.ViewGroup;

import org.jetbrains.annotations.NotNull;

import tech.thdev.androidrecyclerview.adapter.model.BasicAdapterContract;
import tech.thdev.androidrecyclerview.adapter.holder.BasicViewHolder;
import tech.thdev.androidrecyclerview.data.BasicItem;
import tech.thdev.support.widget.adapter.BaseRecyclerAdapter;
import tech.thdev.support.widget.adapter.view.BaseRecyclerViewHolder;

/**
 * Created by Tae-hwan on 10/10/2016.
 */

public class BasicAdapter
        extends BaseRecyclerAdapter<BasicItem>
        implements BasicAdapterContract.Model, BasicAdapterContract.View {

    public BasicAdapter(@NotNull Context context) {
        super(context);
    }

    @Override
    public BaseRecyclerViewHolder<BasicItem> onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BasicViewHolder(parent, this);
    }

    @Override
    public void reload() {
        notifyDataSetChanged();
    }
}
