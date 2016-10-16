package tech.thdev.support.widget.adapter.open

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import tech.thdev.support.widget.adapter.BaseRecyclerAdapter
import tech.thdev.support.widget.data.BaseItem

/**
 * Created by Tae-hwan on 10/10/2016.
 */

open class OpenBaseViewHolder<ITEM : BaseItem>(open val adapter: BaseRecyclerAdapter<ITEM>, itemView: View)
    : RecyclerView.ViewHolder(itemView) {

    /**
     * NotNull item
     */
    open fun onViewHolder(item: ITEM, position: Int) {
    }

    /**
     * Nullable item
     */
    open fun onViewHolder(position: Int) {
    }

    open protected val context: Context = adapter.context
}