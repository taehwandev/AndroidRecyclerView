package tech.thdev.androidrecyclerview.adapter.holder

import android.view.ViewGroup
import android.widget.ImageView
import tech.thdev.androidrecyclerview.R
import tech.thdev.androidrecyclerview.data.Image
import tech.thdev.support.widget.adapter.BaseRecyclerAdapter
import tech.thdev.support.widget.adapter.view.BaseRecyclerViewHolder

/**
 * Created by Tae-hwan on 17/10/2016.
 */

class ImageLargeViewHolder(parent: ViewGroup?, adapter: BaseRecyclerAdapter<Image>) :
        BaseRecyclerViewHolder<Image>(R.layout.item_large_view, parent, adapter) {

    private val image by lazy {
        itemView?.findViewById(R.id.img_large) as ImageView
    }

    override fun onViewHolder(item: Image, position: Int) {
        image.setImageResource(item.img)
    }
}