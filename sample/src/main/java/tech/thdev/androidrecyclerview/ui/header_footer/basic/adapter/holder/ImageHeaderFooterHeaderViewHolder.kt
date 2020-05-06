package tech.thdev.androidrecyclerview.ui.header_footer.basic.adapter.holder

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_small_image.view.*
import tech.thdev.androidrecyclerview.R
import tech.thdev.androidrecyclerview.data.FlipItems
import tech.thdev.support.widget.adapter.simple.holder.BaseViewHolder

/**
 * Created by Tae-hwan on 25/10/2016.
 */
class ImageHeaderFooterHeaderViewHolder(
    parent: ViewGroup,
    adapter: RecyclerView.Adapter<*>
) : BaseViewHolder<FlipItems>(R.layout.item_header_image_sample, parent, adapter) {

    override fun onBindViewHolder(item: FlipItems?, position: Int) {
        item?.let {
            itemView.image_view.setImageResource(it.imageList[0].img)
        }
    }
}