package tech.thdev.androidrecyclerview.view.basic.mvp.adapter.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import butterknife.BindView;
import tech.thdev.androidrecyclerview.R;
import tech.thdev.support.widget.adapter.simple.BaseSimpleRecyclerAdapter;
import tech.thdev.support.widget.adapter.simple.holder.BaseViewHolder;

/**
 * Created by Tae-hwan on 10/10/2016.
 */

public class BasicJavaViewHolder extends BaseViewHolder<String> {

    @BindView(R.id.text_view)
    TextView textView;

    public BasicJavaViewHolder(@Nullable ViewGroup parent, @NotNull BaseSimpleRecyclerAdapter<String> adapter) {
        super(R.layout.item_simple_text_view, parent, adapter);
    }

    @Override
    public void onBindViewHolder(String item, final int position) {
        textView.setText(item);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getOnItemClick().onItemClick(getAdapter(), position);
            }
        });
    }
}