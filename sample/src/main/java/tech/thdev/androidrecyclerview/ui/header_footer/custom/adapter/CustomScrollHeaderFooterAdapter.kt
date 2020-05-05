package tech.thdev.androidrecyclerview.ui.header_footer.custom.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tech.thdev.androidrecyclerview.data.LocalImage
import tech.thdev.androidrecyclerview.ui.header_footer.custom.adapter.holder.CustomScrollFooterViewHolder
import tech.thdev.androidrecyclerview.ui.header_footer.custom.adapter.holder.CustomScrollHeaderViewHolder
import tech.thdev.androidrecyclerview.ui.header_footer.custom.adapter.holder.CustomScrollSmallImageViewHolder
import tech.thdev.androidrecyclerview.ui.header_footer.custom.adapter.model.AdapterHeaderFooterContract
import tech.thdev.support.widget.adapter.header_footer.BaseHeaderFooterTypedefRecyclerAdapter
import java.util.*

/**
 * Created by Tae-hwan on 01/11/2016.
 */
class CustomScrollHeaderFooterAdapter() :
    BaseHeaderFooterTypedefRecyclerAdapter<LocalImage, LocalImage, Objects>(),
    AdapterHeaderFooterContract.Model<LocalImage, LocalImage, Objects>,
    AdapterHeaderFooterContract.View {

    override fun onCreateItemViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CustomScrollSmallImageViewHolder(
            parent,
            this
        )
    }

    override fun onCreateHeaderViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        return CustomScrollHeaderViewHolder(
            parent,
            this
        )
    }

    override fun onCreateFooterViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        return CustomScrollFooterViewHolder(
            parent,
            this
        )
    }

    override fun reload() {
        notifyDataSetChanged()
    }

    override val headerItemPosition: Int
        get() = if (isHeader) 0 else -1

    override val footerItemPosition: Int
        get() = if (isFooter) itemCount else -1
}