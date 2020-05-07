package tech.thdev.androidrecyclerview.ui.custom_scroll.adapter.holder

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_custom_scroll_image.view.*
import kotlinx.android.synthetic.main.item_large_view.view.tv_message
import tech.thdev.androidrecyclerview.R
import tech.thdev.androidrecyclerview.data.LocalImage
import tech.thdev.support.widget.adapter.simple.holder.BaseViewHolder

/**
 * Created by Tae-hwan on 01/11/2016.
 */
class CustomScrollSmallImageViewHolder(
    parent: ViewGroup,
    adapter: RecyclerView.Adapter<*>
) : BaseViewHolder<LocalImage?>(R.layout.item_custom_scroll_image, parent, adapter) {

    override fun onBindViewHolder(item: LocalImage?, position: Int) {
        if (item == null) return
        itemView.tv_message.text = item.title
        Glide.with(context)
            .load(item.resource)
            .centerCrop()
            .into(itemView.image_view)
    }
}