package tech.thdev.support.widget.adapter

import android.content.Context
import android.view.ViewGroup
import tech.thdev.support.widget.adapter.view.BaseRecyclerViewHolder

/**
 * Created by Tae-hwan on 24/10/2016.
 */
abstract class BaseHFRecyclerAdapter<ITEM>(context: Context) : BaseSimpleRecyclerAdapter<ITEM>(context) {

    val VIEW_TYPE_HEADER = -100
    val VIEW_TYPE_FOOTER = -200

    var headerItem: ITEM? = null
    var footerItem: ITEM? = null

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

    override fun onBindViewHolder(holder: BaseRecyclerViewHolder<ITEM>?, position: Int) {
        getItem(position)
                ?.let { holder?.onViewHolder(it, position) }
                ?: holder?.onViewHolder(position)
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

    override fun getItem(position: Int) = when (getFooterItem(getHeaderItem(position))) {
        VIEW_TYPE_HEADER -> headerItem
        VIEW_TYPE_FOOTER -> footerItem
        else -> super.getItem(position)
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