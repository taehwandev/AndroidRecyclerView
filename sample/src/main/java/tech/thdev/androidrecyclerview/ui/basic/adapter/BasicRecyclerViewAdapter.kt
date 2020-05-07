package tech.thdev.androidrecyclerview.ui.basic.adapter

import android.view.ViewGroup
import tech.thdev.androidrecyclerview.ui.basic.adapter.holder.BasicRecyclerViewViewHolder
import tech.thdev.support.widget.adapter.simple.BaseSimpleRecyclerAdapter
import tech.thdev.support.widget.adapter.simple.holder.BaseViewHolder

/**
 * Created by Tae-hwan on 10/10/2016.
 */
class BasicRecyclerViewAdapter : BaseSimpleRecyclerAdapter<String>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<String> =
        BasicRecyclerViewViewHolder(parent, this)

    override fun onItemViewType(position: Int): Int {
        return 0
    }
}
