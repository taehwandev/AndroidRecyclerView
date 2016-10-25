package tech.thdev.androidrecyclerview.adapter.hfsample

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import tech.thdev.androidrecyclerview.adapter.hfsample.holder.ImageFooterViewHolder
import tech.thdev.androidrecyclerview.adapter.hfsample.holder.ImageHeaderViewHolder
import tech.thdev.androidrecyclerview.adapter.hfsample.model.ImageHFAdapterContract
import tech.thdev.androidrecyclerview.adapter.holder.ImageLargeViewHolder
import tech.thdev.androidrecyclerview.data.FlipItems
import tech.thdev.androidrecyclerview.data.Image
import tech.thdev.support.widget.adapter.header_view.BaseHFTypedefRecyclerAdapter
import tech.thdev.support.widget.adapter.simple.BaseSimpleRecyclerAdapter

/**
 * Created by Tae-hwan on 24/10/2016.
 */

class ImageHFSample(context: Context) :
        BaseHFTypedefRecyclerAdapter<Image, FlipItems, Any>(context),
        ImageHFAdapterContract.Model, ImageHFAdapterContract.View{

    override var headerItem: FlipItems? = null

    override var footerItem: Any? = null

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder? {
        when (viewType) {
            VIEW_TYPE_HEADER -> return ImageHeaderViewHolder(parent, this as BaseSimpleRecyclerAdapter<FlipItems>)
            VIEW_TYPE_FOOTER -> return ImageFooterViewHolder(parent, this as BaseSimpleRecyclerAdapter<Any>)
            else -> return ImageLargeViewHolder(parent, this as BaseSimpleRecyclerAdapter<Image>)
        }
    }

    override fun addHeaderItems(headerItem: FlipItems?) {
        this.headerItem = headerItem
    }

    override fun reload() {
        notifyDataSetChanged()
    }
}