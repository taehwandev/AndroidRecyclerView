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

    /**
     * Header use info
     */
    private var isHeader = false

    override var headerItem: HEADER? = null
        set(value) {
            isHeader = true
        }

    /**
     * Footer use info
     */
    private var isFooter = false

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

    override fun getItemCount(): Int {
        var count = super.getItemCount()
        if (isHeader) ++count
        if (isFooter) ++count
        return count
    }

    override fun getRealItemCount() = super.getItemCount()
}