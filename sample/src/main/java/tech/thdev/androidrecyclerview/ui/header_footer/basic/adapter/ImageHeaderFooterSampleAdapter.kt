package tech.thdev.androidrecyclerview.ui.header_footer.basic.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tech.thdev.androidrecyclerview.data.FlipItems
import tech.thdev.androidrecyclerview.data.Image
import tech.thdev.androidrecyclerview.ui.header_footer.basic.adapter.holder.ImageHeaderFooterFooterViewHolder
import tech.thdev.androidrecyclerview.ui.header_footer.basic.adapter.holder.ImageHeaderFooterHeaderViewHolder
import tech.thdev.androidrecyclerview.ui.header_footer.basic.adapter.holder.ImageHeaderFooterViewHolder
import tech.thdev.androidrecyclerview.ui.header_footer.basic.adapter.model.ImageHeaderFooterAdapterContract
import tech.thdev.support.widget.adapter.header_footer.BaseHeaderFooterTypedefRecyclerAdapter

/**
 * Created by Tae-hwan on 24/10/2016.
 */

class ImageHeaderFooterSampleAdapter :
    BaseHeaderFooterTypedefRecyclerAdapter<Image, FlipItems, Any>(),
    ImageHeaderFooterAdapterContract.Model, ImageHeaderFooterAdapterContract.View {

    override fun onCreateHeaderViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        return ImageHeaderFooterHeaderViewHolder(parent, this)
    }

    override fun onCreateFooterViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        return ImageHeaderFooterViewHolder(parent, this)
    }

    override fun onCreateItemViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ImageHeaderFooterFooterViewHolder(parent, this)
    }

    override fun reload() {
        notifyDataSetChanged()
    }
}