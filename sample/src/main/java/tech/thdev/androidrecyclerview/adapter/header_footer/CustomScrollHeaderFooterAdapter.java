package tech.thdev.androidrecyclerview.adapter.header_footer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

import tech.thdev.androidrecyclerview.adapter.header_footer.holder.CustomScrollFooterViewHolder;
import tech.thdev.androidrecyclerview.adapter.header_footer.holder.CustomScrollHeaderViewHolder;
import tech.thdev.androidrecyclerview.adapter.header_footer.holder.CustomScrollSmallImageViewHolder;
import tech.thdev.androidrecyclerview.adapter.model.AdapterHeaderFooterContract;
import tech.thdev.androidrecyclerview.data.LocalImage;
import tech.thdev.support.widget.adapter.header_footer.BaseHeaderFooterTypedefRecyclerAdapter;

/**
 * Created by Tae-hwan on 01/11/2016.
 */

public class CustomScrollHeaderFooterAdapter extends
        BaseHeaderFooterTypedefRecyclerAdapter<LocalImage, LocalImage, Objects> implements
        AdapterHeaderFooterContract.Model<LocalImage, LocalImage, Objects>, AdapterHeaderFooterContract.View {

    public CustomScrollHeaderFooterAdapter(@NotNull Context context) {
        super(context);
    }

    @Nullable
    @Override
    public RecyclerView.ViewHolder onCreateItemViewHolder(@Nullable ViewGroup parent, int viewType) {
        return new CustomScrollSmallImageViewHolder(parent, this);
    }

    @Nullable
    @Override
    public RecyclerView.ViewHolder onCreateHeaderViewHolder(@Nullable ViewGroup parent, int viewType) {
        return new CustomScrollHeaderViewHolder(parent, this);
    }

    @Nullable
    @Override
    public RecyclerView.ViewHolder onCreateFooterViewHolder(@Nullable ViewGroup parent, int viewType) {
        return new CustomScrollFooterViewHolder(parent, this);
    }

    @Override
    public void reload() {
        notifyDataSetChanged();
    }

    @Override
    public int getHeaderItemPosition() {
        return isHeader() ? 0 : -1;
    }

    @Override
    public int getFooterItemPosition() {
        return isFooter() ? getItemCount() : -1;
    }
}
