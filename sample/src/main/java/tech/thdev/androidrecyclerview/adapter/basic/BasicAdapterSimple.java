package tech.thdev.androidrecyclerview.adapter.basic;

import android.content.Context;
import android.view.ViewGroup;

import org.jetbrains.annotations.NotNull;

import tech.thdev.androidrecyclerview.adapter.basic.holder.BasicViewHolder;
import tech.thdev.androidrecyclerview.adapter.model.AdapterContract;
import tech.thdev.androidrecyclerview.data.BasicItem;
import tech.thdev.support.widget.adapter.BaseViewTypeRecyclerAdapter;
import tech.thdev.support.widget.adapter.view.BaseRecyclerViewHolder;

/**
 * Created by Tae-hwan on 10/10/2016.
 */

public class BasicAdapterSimple
        extends BaseViewTypeRecyclerAdapter<BasicItem>
        implements AdapterContract.Model<BasicItem>, AdapterContract.View {

    public BasicAdapterSimple(@NotNull Context context) {
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
