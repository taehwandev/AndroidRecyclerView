package tech.thdev.androidrecyclerview.adapter.header_footer

import android.content.Context
import android.view.ViewGroup
import tech.thdev.androidrecyclerview.adapter.header_footer.holder.ImageHFFooterViewHolder
import tech.thdev.androidrecyclerview.adapter.header_footer.holder.ImageHFViewHolder
import tech.thdev.androidrecyclerview.adapter.header_footer.holder.ImageHFHeaderViewHolder
import tech.thdev.androidrecyclerview.adapter.header_footer.model.ImageHFAdapterContract
import tech.thdev.androidrecyclerview.data.FlipItems
import tech.thdev.androidrecyclerview.data.Image
import tech.thdev.support.widget.adapter.header_footer.BaseHeaderFooterTypedefRecyclerAdapter

/**
 * Created by Tae-hwan on 24/10/2016.
 */

class ImageHeaderFooterSampleAdapter(context: Context) :
        BaseHeaderFooterTypedefRecyclerAdapter<Image, FlipItems, Any>(context),
        ImageHFAdapterContract.Model, ImageHFAdapterContract.View {

    override fun onCreateItemViewHolder(parent: ViewGroup?, viewType: Int)
            = ImageHFViewHolder(parent, this)

    override fun onCreateHeaderViewHolder(parent: ViewGroup?, viewType: Int)
            = ImageHFHeaderViewHolder(parent, this)

    override fun onCreateFooterViewHolder(parent: ViewGroup?, viewType: Int)
            = ImageHFFooterViewHolder(parent, this)

    override fun reload() {
        notifyDataSetChanged()
    }
}