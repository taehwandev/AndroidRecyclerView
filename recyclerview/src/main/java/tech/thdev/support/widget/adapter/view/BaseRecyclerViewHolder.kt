package tech.thdev.support.widget.adapter.view

import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import tech.thdev.support.widget.adapter.BaseRecyclerAdapter
import tech.thdev.support.widget.adapter.open.OpenBaseViewHolder
import tech.thdev.support.widget.data.BaseItem

/**
 * Created by Tae-hwan on 10/10/2016.
 */

abstract class BaseRecyclerViewHolder<ITEM: BaseItem>(adapter: BaseRecyclerAdapter<ITEM>, itemView: View)
    : OpenBaseViewHolder<ITEM>(adapter, itemView) {

    constructor(@LayoutRes layoutRes: Int, parent: ViewGroup?, adapter: BaseRecyclerAdapter<ITEM>)
        : this(adapter, LayoutInflater.from(adapter.context).inflate(layoutRes, parent, false))

    init {
        ButterKnife.bind(BaseRecyclerViewHolder@this, itemView)
    }

    /**
     * NonNull item
     */
    override abstract fun onViewHolder(item: ITEM, position: Int)
}