package tech.thdev.androidrecyclerview.adapter.basic.holder;

import android.view.ViewGroup;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import butterknife.BindView;
import tech.thdev.androidrecyclerview.R;
import tech.thdev.androidrecyclerview.adapter.basic.BasicAdapterSimple;
import tech.thdev.androidrecyclerview.data.BasicItem;
import tech.thdev.support.widget.adapter.BaseSimpleRecyclerAdapter;
import tech.thdev.support.widget.adapter.view.BaseRecyclerViewHolder;

/**
 * Created by Tae-hwan on 10/10/2016.
 */

public class BasicViewHolder extends BaseRecyclerViewHolder<BasicItem> {

    @BindView(R.id.text)
    TextView textView;

    public BasicViewHolder(@Nullable ViewGroup parent, @NotNull BaseSimpleRecyclerAdapter<BasicItem> adapter) {
        super(R.layout.item_basic, parent, adapter);
    }

    @Override
    public void onViewHolder(@NotNull BasicItem item, int position) {
        textView.setText(item.name);
    }

    @NotNull
    @Override
    public BasicAdapterSimple getAdapter() {
        return (BasicAdapterSimple) super.getAdapter();
    }
}