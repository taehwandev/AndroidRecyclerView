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

    protected val VIEW_TYPE_HEADER = -100
    protected val VIEW_TYPE_FOOTER = -200

    /**
     * Header use info
     */
    protected var isHeader = false
        private set

    override var headerItem: HEADER? = null
        set(value) {
            isHeader = true
        }

    /**
     * Footer use info
     */
    protected var isFooter = false
        private set

    override var footerItem: FOOTER? = null
        set(value) {
            isFooter = true
        }

    /**
     * Item view create
     */
    abstract fun onCreateItemViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder?

    /**
     * Header view create
     */
    abstract fun onCreateHeaderViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder?

    /**
     * Footer view create
     */
    abstract fun onCreateFooterViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder?

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) =
            when (viewType) {
                VIEW_TYPE_HEADER -> onCreateHeaderViewHolder(parent, viewType)
                VIEW_TYPE_FOOTER -> onCreateFooterViewHolder(parent, viewType)
                else -> onCreateItemViewHolder(parent, viewType)
            }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        when (getItemViewType(position)) {
            VIEW_TYPE_HEADER ->
                (holder as? BaseViewHolder<HEADER>)?.onViewHolder(headerItem, VIEW_TYPE_HEADER)
            VIEW_TYPE_FOOTER ->
                (holder as? BaseViewHolder<FOOTER>)?.onViewHolder(footerItem, VIEW_TYPE_FOOTER)
            else -> {
                val realPosition = getRealItemPosition(position)
                (holder as? BaseViewHolder<ITEM>)?.
                        onViewHolder(getItem(realPosition), realPosition)
            }
        }
    }

    override fun getItemCount(): Int {
        var count = super.getItemCount()
        if (isHeader) ++count
        if (isFooter) ++count
        return count
    }

    /**
     * Header/Footer viewType
     */
    override fun getItemViewType(position: Int): Int {
        if (hasHeaderItems(position)) {
            return VIEW_TYPE_HEADER
        }
        if (hasFooterItem(position)) {
            return VIEW_TYPE_FOOTER
        }
        return super.getItemViewType(getRealItemPosition(position))
    }

    override fun getRealItemCount() = super.getItemCount()

    /**
     * has header item
     */
    override fun hasHeaderItems(position: Int) = isHeader && position == 0

    /**
     * has footer item
     */
    override fun hasFooterItem(position: Int) = isFooter && position == itemCount - 1

    /**
     * Position without header
     */
    protected fun getRealItemPosition(position: Int)
            = if (isHeader) position - 1 else position
}