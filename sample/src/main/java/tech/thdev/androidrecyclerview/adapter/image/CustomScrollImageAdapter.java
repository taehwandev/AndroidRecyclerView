package tech.thdev.androidrecyclerview.adapter.image;

import android.content.Context;
import android.view.ViewGroup;

import tech.thdev.androidrecyclerview.adapter.image.holder.LargeImageViewHolder;
import tech.thdev.androidrecyclerview.adapter.model.AdapterContract;
import tech.thdev.androidrecyclerview.data.LocalImage;
import tech.thdev.support.widget.adapter.BaseRecyclerAdapter;
import tech.thdev.support.widget.adapter.open.OpenBaseViewHolder;

/**
 * Created by Tae-hwan on 18/10/2016.
 */

public class CustomScrollImageAdapter
        extends BaseRecyclerAdapter<LocalImage>
        implements AdapterContract.Model<LocalImage>, AdapterContract.View {

    public CustomScrollImageAdapter(Context context) {
        super(context);
    }

    @Override
    public OpenBaseViewHolder<LocalImage> onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LargeImageViewHolder(parent, this);
    }

    @Override
    public void reload() {
        notifyDataSetChanged();
    }
}
