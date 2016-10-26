package tech.thdev.support.widget.adapter.header_footer

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import tech.thdev.support.widget.adapter.AbstractRecyclerAdapter
import tech.thdev.support.widget.adapter.header_footer.model.BaseHeaderFooterRecyclerModel
import tech.thdev.support.widget.adapter.simple.holder.BaseViewHolder

/**
 * Created by Tae-hwan on 24/10/2016.
 */
abstract class BaseHeaderFooterRecyclerAdapter<ITEM, HEADER, FOOTER>(context: Context) :
        AbstractRecyclerAdapter<ITEM, RecyclerView.ViewHolder>(context),
        BaseHeaderFooterRecyclerModel<ITEM, HEADER, FOOTER> {

    private val VIEW_TYPE_HEADER = -100
    private val VIEW_TYPE_FOOTER = -200

    private var isHeader = false
    private var isFooter = false

    override var headerItem: HEADER? = null
        set(value) {
            isHeader = true
        }
    override var footerItem: FOOTER? = null
        set(value) {
            isFooter = true
        }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) =
        when (viewType) {
            VIEW_TYPE_HEADER -> onCreateHeaderViewHolder(parent, viewType)
            VIEW_TYPE_FOOTER -> onCreateFooterViewHolder(parent, viewType)
            else -> onCreateItemViewHolder(parent, viewType)
        }

    /**
     * Item view create
     */
    abstract fun onCreateItemViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder

    /**
     * Header view create
     */
    abstract fun onCreateHeaderViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder

    /**
     * Footer view create
     */
    abstract fun onCreateFooterViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder

    override fun getViewType(position: Int): Int {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

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
        var count = super.getItemCount()
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

    override fun getRealItemCount() = super.getItemCount()
}