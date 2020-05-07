package tech.thdev.support.widget.adapter.simple.holder

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import tech.thdev.support.widget.adapter.AbstractArrayRecyclerAdapter
import tech.thdev.support.widget.listener.OnItemClickListener
import tech.thdev.support.widget.listener.OnItemLongClickListener

/**
 * Created by Tae-hwan on 10/10/2016.
 */
abstract class BaseViewHolder<ITEM>(
    open val adapter: RecyclerView.Adapter<*>,
    override val containerView: View
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    constructor(
        @LayoutRes layoutRes: Int,
        parent: ViewGroup,
        adapter: RecyclerView.Adapter<*>
    ) : this(
        adapter,
        LayoutInflater.from(parent.context)
            .inflate(layoutRes, parent, false)
    )

    /**
     * Definition of a holder
     */
    abstract fun onBindViewHolder(item: ITEM?, position: Int)

    protected val context: Context = itemView.context

    /**
     * OnItemClick definition
     */
    protected val onItemClick: OnItemClickListener?
        get() = (adapter as? AbstractArrayRecyclerAdapter<*, *>)?.onItemClickListener

    /**
     * OnItemLongClick definition
     */
    protected val onItemLongClick: OnItemLongClickListener?
        get() = (adapter as? AbstractArrayRecyclerAdapter<*, *>)?.onItemLongClickListener
}