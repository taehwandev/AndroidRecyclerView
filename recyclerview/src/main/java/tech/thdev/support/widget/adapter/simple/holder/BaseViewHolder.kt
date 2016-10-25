package tech.thdev.support.widget.adapter.simple.holder

import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import tech.thdev.support.widget.adapter.simple.BaseSimpleRecyclerAdapter

/**
 * Created by Tae-hwan on 10/10/2016.
 */

abstract class BaseViewHolder<ITEM>(
        open val adapter: BaseSimpleRecyclerAdapter<*>, itemView: View) :
        RecyclerView.ViewHolder(itemView) {

    constructor(@LayoutRes layoutRes: Int,
                parent: ViewGroup?, adapter: BaseSimpleRecyclerAdapter<*>)
    : this(adapter, LayoutInflater.from(adapter.context).inflate(layoutRes, parent, false))

    init {
        ButterKnife.bind(BaseRecyclerViewHolder@this, itemView)
    }

    /**
     * NonNull item
     */
    abstract fun onViewHolder(item: ITEM, position: Int)

    /**
     * Nullable item
     */
    open fun onViewHolder(position: Int) {
    }

    open protected val context = adapter.context
}