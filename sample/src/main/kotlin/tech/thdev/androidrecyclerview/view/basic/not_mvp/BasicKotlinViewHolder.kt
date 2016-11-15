package tech.thdev.androidrecyclerview.view.basic.not_mvp

import android.view.ViewGroup
import android.widget.TextView
import tech.thdev.androidrecyclerview.R
import tech.thdev.support.widget.adapter.simple.holder.BaseViewHolder

/**
 * Created by Tae-hwan on 14/11/2016.
 */

class BasicKotlinViewHolder(parent: ViewGroup?, adapter: BasicKotlinAdapter) :
        BaseViewHolder<String>(R.layout.item_simple_text_view, parent, adapter) {

    private val textView by lazy {
        itemView.findViewById(R.id.text_view) as TextView
    }

    override fun onBindViewHolder(item: String?, position: Int) {
        textView.text = item

        itemView.setOnClickListener {
            onItemClick?.onItemClick(adapter, position)
        }
    }
}