package tech.thdev.androidrecyclerview.adapter.image;

import android.content.Context;
import android.view.ViewGroup;

import tech.thdev.androidrecyclerview.adapter.image.holder.LargeImageViewHolder;
import tech.thdev.androidrecyclerview.adapter.model.AdapterContract;
import tech.thdev.androidrecyclerview.data.LocalImage;
import tech.thdev.support.widget.adapter.BaseViewTypeRecyclerAdapter;
import tech.thdev.support.widget.adapter.view.BaseRecyclerViewHolder;

/**
 * Created by Tae-hwan on 18/10/2016.
 */

public class CustomScrollImageAdapterSimple
        extends BaseViewTypeRecyclerAdapter<LocalImage>
        implements AdapterContract.Model<LocalImage>, AdapterContract.View {

    public CustomScrollImageAdapterSimple(Context context) {
        super(context);
    }

    @Override
    public BaseRecyclerViewHolder<LocalImage> onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LargeImageViewHolder(parent, this);
    }

    @Override
    public void reload() {
        notifyDataSetChanged();
    }
}
