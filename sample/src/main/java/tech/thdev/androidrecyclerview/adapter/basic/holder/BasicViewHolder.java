package tech.thdev.androidrecyclerview.adapter.basic.holder;

import android.view.ViewGroup;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import butterknife.BindView;
import tech.thdev.androidrecyclerview.R;
import tech.thdev.androidrecyclerview.adapter.basic.BasicAdapterSimpleDefinition;
import tech.thdev.androidrecyclerview.data.BasicItem;
import tech.thdev.support.widget.adapter.simple.BaseTypedefRecyclerAdapter;
import tech.thdev.support.widget.adapter.simple.holder.BaseViewHolder;

/**
 * Created by Tae-hwan on 10/10/2016.
 */

public class BasicViewHolder extends BaseViewHolder<BasicItem> {

    @BindView(R.id.text)
    TextView textView;

    public BasicViewHolder(@Nullable ViewGroup parent, @NotNull BaseTypedefRecyclerAdapter<BasicItem> adapter) {
        super(R.layout.item_basic, parent, adapter);
    }

    @Override
    public void onBindViewHolder(BasicItem item, int position) {
        textView.setText(item.name);
    }

    @NotNull
    @Override
    public BasicAdapterSimpleDefinition getAdapter() {
        return (BasicAdapterSimpleDefinition) super.getAdapter();
    }
}