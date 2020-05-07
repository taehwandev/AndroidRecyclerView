package tech.thdev.androidrecyclerview.ui.custom_scroll.adapter.holder

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tech.thdev.androidrecyclerview.R
import tech.thdev.androidrecyclerview.data.LocalImage
import tech.thdev.support.widget.adapter.simple.holder.BaseViewHolder

/**
 * Created by Tae-hwan on 01/11/2016.
 */
class CustomScrollHeaderViewHolder(
    parent: ViewGroup,
    adapter: RecyclerView.Adapter<*>
) : BaseViewHolder<LocalImage?>(R.layout.item_custom_scroll_header, parent, adapter) {
    override fun onBindViewHolder(item: LocalImage?, position: Int) {}
}