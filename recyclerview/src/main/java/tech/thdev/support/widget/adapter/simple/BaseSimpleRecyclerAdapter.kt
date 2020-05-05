package tech.thdev.support.widget.adapter.simple

import tech.thdev.support.widget.adapter.AbstractArrayRecyclerAdapter
import tech.thdev.support.widget.adapter.simple.holder.BaseViewHolder

/**
 * Created by Tae-hwan on 25/10/2016.
 *
 * Simple RecyclerView
 */

abstract class BaseSimpleRecyclerAdapter<ITEM> :
    AbstractArrayRecyclerAdapter<ITEM, BaseViewHolder<ITEM>>() {

    override fun onBindViewHolder(holder: BaseViewHolder<ITEM>, position: Int) {
        holder.onBindViewHolder(getItem(position), position)
    }
}