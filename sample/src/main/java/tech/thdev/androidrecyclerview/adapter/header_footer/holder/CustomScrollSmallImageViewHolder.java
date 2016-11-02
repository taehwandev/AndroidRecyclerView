package tech.thdev.androidrecyclerview.adapter.header_footer.holder;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import butterknife.BindView;
import tech.thdev.androidrecyclerview.R;
import tech.thdev.androidrecyclerview.data.LocalImage;
import tech.thdev.support.widget.adapter.simple.holder.BaseViewHolder;

/**
 * Created by Tae-hwan on 01/11/2016.
 */

public class CustomScrollSmallImageViewHolder extends BaseViewHolder<LocalImage> {

    @BindView(R.id.image_view)
    ImageView imageView;

    @BindView(R.id.tv_message)
    TextView tvMessage;

    public CustomScrollSmallImageViewHolder(@Nullable ViewGroup parent, @NotNull RecyclerView.Adapter<?> adapter) {
        super(R.layout.item_small_image, parent, adapter);
    }

    @Override
    public void onViewHolder(@Nullable LocalImage localImage, int position) {
        if (localImage == null) return;

        tvMessage.setText(localImage.getTitle());

        Glide.with(getContext())
                .load(localImage.getResource())
                .centerCrop()
                .placeholder(0)
                .into(imageView);
    }
}
