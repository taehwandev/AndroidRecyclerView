package tech.thdev.androidrecyclerview.adapter.hfsample.holder

import android.view.ViewGroup
import tech.thdev.androidrecyclerview.R
import tech.thdev.support.widget.adapter.simple.BaseSimpleRecyclerAdapter
import tech.thdev.support.widget.adapter.simple.holder.BaseViewHolder

/**
 * Created by Tae-hwan on 25/10/2016.
 */

class ImageFooterViewHolder(
        parent: ViewGroup?, adapter: BaseSimpleRecyclerAdapter<Any>) :
        BaseViewHolder<Any>(R.layout.item_footer_image_sample, parent, adapter) {

    override fun onViewHolder(item: Any, position: Int) {

    }

    override fun onViewHolder(position: Int) {
        super.onViewHolder(position)
    }
}