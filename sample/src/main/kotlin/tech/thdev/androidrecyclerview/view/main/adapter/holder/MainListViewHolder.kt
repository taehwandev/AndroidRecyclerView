package tech.thdev.androidrecyclerview.view.main.adapter.holder

import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_main_list.view.*
import tech.thdev.androidrecyclerview.R
import tech.thdev.androidrecyclerview.data.PrefixItem
import tech.thdev.androidrecyclerview.view.main.adapter.MainListAdapter
import tech.thdev.support.widget.adapter.simple.BaseTypedefRecyclerAdapter
import tech.thdev.support.widget.adapter.simple.holder.BaseViewHolder

/**
 * Created by Tae-hwan on 11/10/2016.
 */

class MainListViewHolder(parent: ViewGroup?, adapterSimple: BaseTypedefRecyclerAdapter<PrefixItem>) :
        BaseViewHolder<PrefixItem>(R.layout.item_main_list, parent, adapterSimple) {

    override fun onBindViewHolder(item: PrefixItem?, position: Int) {
        with(itemView) {
            tv_title.text = item?.title

        }
        itemView?.setOnClickListener { onItemClick?.onItemClick(adapter, position) }
    }

    override val adapter: MainListAdapter
        get() = super.adapter as MainListAdapter
}