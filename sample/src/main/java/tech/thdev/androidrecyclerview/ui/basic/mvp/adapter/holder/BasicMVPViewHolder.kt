package tech.thdev.androidrecyclerview.ui.basic.mvp.adapter.holder

import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_simple_text_view.view.*
import tech.thdev.androidrecyclerview.R
import tech.thdev.support.widget.adapter.simple.BaseSimpleRecyclerAdapter
import tech.thdev.support.widget.adapter.simple.holder.BaseViewHolder

/**
 * Created by Tae-hwan on 10/10/2016.
 */
class BasicMVPViewHolder(
    parent: ViewGroup,
    adapter: BaseSimpleRecyclerAdapter<String>
) : BaseViewHolder<String?>(R.layout.item_simple_text_view, parent, adapter) {

    override fun onBindViewHolder(item: String?, position: Int) {
        itemView.text_view.text = item
        itemView.setOnClickListener { onItemClick!!.onItemClick(adapter, position) }
    }
}