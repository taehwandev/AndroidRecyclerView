package tech.thdev.support.widget.adapter.model

import androidx.recyclerview.widget.RecyclerView
import tech.thdev.support.widget.listener.OnItemClickListener
import tech.thdev.support.widget.listener.OnItemLongClickListener

/**
 * Created by Tae-hwan on 09/11/2016.
 *
 * RecyclerView.Adapter View definition
 */
interface BaseRecyclerView {

    var onItemClickListener: OnItemClickListener?

    fun setOnItemClickListener(listener: (RecyclerView.Adapter<*>, Int) -> Unit)

    var onItemLongClickListener: OnItemLongClickListener?

    fun setOnItemLongClickListener(listener: (RecyclerView.Adapter<*>, Int) -> Boolean)

    fun notifyDataSetChanged()
}