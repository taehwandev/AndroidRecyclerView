package tech.thdev.support.widget.adapter.header_view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import tech.thdev.support.widget.adapter.PrivateRecyclerAdapter
import tech.thdev.support.widget.adapter.simple.holder.BaseViewHolder

/**
 * Created by Tae-hwan on 24/10/2016.
 */
abstract class BaseHFRecyclerAdapter<ITEM, HEADER, FOOTER>(context: Context) : PrivateRecyclerAdapter<ITEM, RecyclerView.ViewHolder>(context) {

    val VIEW_TYPE_HEADER = -100
    val VIEW_TYPE_FOOTER = -200

    abstract var headerItem: HEADER?
    abstract var footerItem: FOOTER?

    /**
     * @return Header item position
     */
    private fun getHeaderItem(position: Int)
            = if (position == 0 && headerItem != null) VIEW_TYPE_HEADER else position

    /**
     * @return Footer item position
     */
    private fun getFooterItem(position: Int)
            = if (position == itemCount - 1 && footerItem != null) VIEW_TYPE_FOOTER else position


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        if (holder == null) return

        when (getFooterItem(getHeaderItem(position))) {
            VIEW_TYPE_HEADER -> {
                headerItem
                        ?.let { (holder as BaseViewHolder<HEADER>).onViewHolder(it, position) }
                        ?: (holder as BaseViewHolder<HEADER>).onViewHolder(position)
            }
            VIEW_TYPE_FOOTER -> {
                footerItem
                        ?.let { (holder as BaseViewHolder<FOOTER>).onViewHolder(it, position) }
                        ?: (holder as BaseViewHolder<FOOTER>).onViewHolder(position)
            }
            else -> {
                getItem(position)
                        ?.let { (holder as BaseViewHolder<ITEM>).onViewHolder(it, position) }
                        ?: (holder as BaseViewHolder<ITEM>).onViewHolder(position)
            }
        }
    }

    /**
     * Header/Footer size contained
     */
    override fun getItemCount(): Int {
        var count = getItemRealCount()
        headerItem?.let { ++count }
        footerItem?.let { ++count }
        return count
    }

    override fun getItemViewType(position: Int)
            = when (getFooterItem(getHeaderItem(position))) {
        VIEW_TYPE_HEADER -> VIEW_TYPE_HEADER
        VIEW_TYPE_FOOTER -> VIEW_TYPE_FOOTER
        else -> getViewType(position)
    }

    override fun clear() {
        headerItem = null
        footerItem = null

        super.clear()
    }
}