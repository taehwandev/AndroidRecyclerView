package tech.thdev.androidrecyclerview.adapter.header_footer.holder

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.ImageView
import tech.thdev.androidrecyclerview.R
import tech.thdev.androidrecyclerview.data.FlipItems
import tech.thdev.support.widget.adapter.simple.holder.BaseViewHolder

/**
 * Created by Tae-hwan on 25/10/2016.
 */

class ImageHFHeaderViewHolder(
        parent: ViewGroup?, adapter: RecyclerView.Adapter<*>) :
        BaseViewHolder<FlipItems>(R.layout.item_header_image_sample, parent, adapter) {

    private val imageView by lazy {
        itemView?.findViewById(R.id.image_view) as ImageView
    }

    override fun onBindViewHolder(item: FlipItems?, position: Int) {
        item?.let {
            imageView.setImageResource(it.imageList[0].img)
        }
    }
}