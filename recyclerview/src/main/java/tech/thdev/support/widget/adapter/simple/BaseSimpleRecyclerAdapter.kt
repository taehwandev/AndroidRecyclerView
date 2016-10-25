package tech.thdev.support.widget.adapter.simple

import android.content.Context
import tech.thdev.support.widget.adapter.PrivateRecyclerAdapter
import tech.thdev.support.widget.adapter.simple.holder.BaseViewHolder

/**
 * Created by Tae-hwan on 25/10/2016.
 */

abstract class BaseSimpleRecyclerAdapter<ITEM>(context: Context) :
        PrivateRecyclerAdapter<ITEM, BaseViewHolder<ITEM>>(context) {

    override fun onBindViewHolder(holder: BaseViewHolder<ITEM>?, position: Int) {
        getItem(position)
                ?.let { holder?.onViewHolder(it, position) }
                ?: holder?.onViewHolder(position)
    }
}