package tech.thdev.androidrecyclerview.adapter.hfsample.holder

import android.util.Log
import android.view.ViewGroup
import android.widget.ImageView
import tech.thdev.androidrecyclerview.R
import tech.thdev.androidrecyclerview.data.FlipItems
import tech.thdev.support.widget.adapter.simple.BaseSimpleRecyclerAdapter
import tech.thdev.support.widget.adapter.simple.holder.BaseViewHolder

/**
 * Created by Tae-hwan on 25/10/2016.
 */

class ImageHeaderViewHolder(
        parent: ViewGroup?, adapter: BaseSimpleRecyclerAdapter<FlipItems>) :
        BaseViewHolder<FlipItems>(R.layout.item_header_image_sample, parent, adapter) {

    private val imageView by lazy {
        itemView?.findViewById(R.id.image_view) as ImageView
    }

    override fun onViewHolder(item: FlipItems, position: Int) {
        imageView.setImageResource(item.imageList[0].img)
        Log.d("TAG", "ImageHeaderViewHolder")
    }
}