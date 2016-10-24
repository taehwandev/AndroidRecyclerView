package tech.thdev.androidrecyclerview.adapter.main.holder

import android.view.ViewGroup
import android.widget.TextView
import tech.thdev.androidrecyclerview.R
import tech.thdev.androidrecyclerview.adapter.main.MainListAdapterSimple
import tech.thdev.androidrecyclerview.data.MainItem
import tech.thdev.support.widget.adapter.BaseSimpleRecyclerAdapter
import tech.thdev.support.widget.adapter.view.BaseRecyclerViewHolder

/**
 * Created by Tae-hwan on 11/10/2016.
 */

class MainListViewHolder(parent: ViewGroup?, adapterSimple: BaseSimpleRecyclerAdapter<MainItem>) :
        BaseRecyclerViewHolder<MainItem>(R.layout.item_main_list, parent, adapterSimple) {

    private val tvTitle by lazy {
        itemView?.findViewById(R.id.tv_title) as TextView
    }

    override fun onViewHolder(item: Any, position: Int) {
        tvTitle.text = item.title
        tvTitle.setOnClickListener { adapter.onClickListener?.onItemClick(adapter, position) }
    }

    override val adapter: MainListAdapterSimple
        get() = super.adapter as MainListAdapterSimple
}