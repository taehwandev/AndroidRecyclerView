package tech.thdev.support.widget.adapter.view

import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import tech.thdev.support.widget.adapter.BaseSimpleRecyclerAdapter

/**
 * Created by Tae-hwan on 10/10/2016.
 */

abstract class BaseRecyclerViewHolder<ITEM>(
        open val adapter: BaseSimpleRecyclerAdapter<ITEM>, itemView: View) :
        RecyclerView.ViewHolder(itemView) {

    constructor(@LayoutRes layoutRes: Int,
                parent: ViewGroup?, adapterSimple: BaseSimpleRecyclerAdapter<ITEM>)
    : this(adapterSimple, LayoutInflater.from(adapterSimple.context).inflate(layoutRes, parent, false))

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