package tech.thdev.androidrecyclerview.ui.local_image.adapter

import android.view.ViewGroup
import tech.thdev.androidrecyclerview.data.Image
import tech.thdev.androidrecyclerview.ui.local_image.adapter.model.LocalImageAdapterContract
import tech.thdev.androidrecyclerview.ui.local_image.adapter.holder.LocalImageViewHolder
import tech.thdev.support.widget.adapter.simple.BaseTypedefRecyclerAdapter
import tech.thdev.support.widget.adapter.simple.holder.BaseViewHolder

/**
 * Created by Tae-hwan on 17/10/2016.
 */

class LocalImageAdapter : BaseTypedefRecyclerAdapter<Image>(),
    LocalImageAdapterContract.Model, LocalImageAdapterContract.View {

    companion object {
        const val VIEW_LARGE_VIEW = 1
        const val VIEW_LIST_VIEW = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Image> {
        return LocalImageViewHolder(
            parent,
            this
        )
    }

    override fun reload() {
        notifyDataSetChanged()
    }
}