package tech.thdev.androidrecyclerview.adapter.main.holder

import android.view.ViewGroup
import android.widget.TextView
import tech.thdev.androidrecyclerview.R
import tech.thdev.androidrecyclerview.adapter.main.MainListAdapter
import tech.thdev.androidrecyclerview.data.MainItem
import tech.thdev.support.widget.adapter.simple.BaseTypedefRecyclerAdapter
import tech.thdev.support.widget.adapter.simple.holder.BaseViewHolder

/**
 * Created by Tae-hwan on 11/10/2016.
 */

class MainListViewHolder(parent: ViewGroup?, adapterSimple: BaseTypedefRecyclerAdapter<MainItem>) :
        BaseViewHolder<MainItem>(R.layout.item_main_list, parent, adapterSimple) {

    private val tvTitle by lazy {
        itemView?.findViewById(R.id.tv_title) as TextView
    }

    override fun onViewHolder(item: MainItem?, position: Int) {
        tvTitle.text = item?.title
        tvTitle.setOnClickListener { adapter.onClickListener?.onItemClick(adapter, position) }
    }

    override val adapter: MainListAdapter
        get() = super.adapter as MainListAdapter
}