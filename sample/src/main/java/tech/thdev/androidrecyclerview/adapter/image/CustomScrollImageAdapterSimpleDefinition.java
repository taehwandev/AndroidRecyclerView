package tech.thdev.androidrecyclerview.adapter.image;

import android.content.Context;
import android.view.ViewGroup;

import tech.thdev.androidrecyclerview.adapter.image.holder.LargeImageViewHolder;
import tech.thdev.androidrecyclerview.adapter.model.AdapterContract;
import tech.thdev.androidrecyclerview.data.LocalImage;
import tech.thdev.support.widget.adapter.simple.BaseTypedefRecyclerAdapter;
import tech.thdev.support.widget.adapter.simple.holder.BaseViewHolder;

/**
 * Created by Tae-hwan on 18/10/2016.
 */

public class CustomScrollImageAdapterSimpleDefinition
        extends BaseTypedefRecyclerAdapter<LocalImage>
        implements AdapterContract.Model<LocalImage>, AdapterContract.View {

    public CustomScrollImageAdapterSimpleDefinition(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder<LocalImage> onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LargeImageViewHolder(parent, this);
    }

    @Override
    public void reload() {
        notifyDataSetChanged();
    }
}
