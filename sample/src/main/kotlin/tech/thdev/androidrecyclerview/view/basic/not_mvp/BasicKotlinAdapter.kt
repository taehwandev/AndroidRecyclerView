package tech.thdev.androidrecyclerview.view.basic.not_mvp

import android.content.Context
import android.view.ViewGroup
import tech.thdev.support.widget.adapter.simple.BaseSimpleRecyclerAdapter
import tech.thdev.support.widget.adapter.simple.holder.BaseViewHolder

/**
 * Created by Tae-hwan on 14/11/2016.
 */

class BasicKotlinAdapter(context: Context) : BaseSimpleRecyclerAdapter<String>(context) {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder<String> {
        return BasicKotlinViewHolder(parent, this)
    }

    override fun onItemViewType(position: Int) = 0
}