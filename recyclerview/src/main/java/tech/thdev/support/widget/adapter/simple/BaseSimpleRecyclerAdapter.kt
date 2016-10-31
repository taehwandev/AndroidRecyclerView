package tech.thdev.support.widget.adapter.simple

import android.content.Context
import tech.thdev.support.widget.adapter.AbstractRecyclerAdapter
import tech.thdev.support.widget.adapter.simple.holder.BaseViewHolder

/**
 * Created by Tae-hwan on 25/10/2016.
 *
 * Simple RecyclerView
 */

abstract class BaseSimpleRecyclerAdapter<ITEM>(context: Context) :
        AbstractRecyclerAdapter<ITEM, BaseViewHolder<ITEM>>(context) {

    override fun onBindViewHolder(holder: BaseViewHolder<ITEM>?, position: Int) {
        holder?.onViewHolder(getItem(position), position)
    }
}