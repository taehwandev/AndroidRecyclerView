package tech.thdev.androidrecyclerview.adapter.header_footer.holder;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import tech.thdev.androidrecyclerview.R;
import tech.thdev.androidrecyclerview.data.LocalImage;
import tech.thdev.support.widget.adapter.simple.holder.BaseViewHolder;

/**
 * Created by Tae-hwan on 01/11/2016.
 */

public class CustomScrollFooterViewHolder extends BaseViewHolder<LocalImage> {

    public CustomScrollFooterViewHolder(@Nullable ViewGroup parent, @NotNull RecyclerView.Adapter<?> adapter) {
        super(R.layout.item_small_image_footer, parent, adapter);
    }

    @Override
    public void onViewHolder(@Nullable LocalImage localImage, int position) {

    }
}
