package tech.thdev.androidrecyclerview.adapter.main

import android.content.Context
import android.view.ViewGroup
import tech.thdev.androidrecyclerview.adapter.main.holder.MainListViewHolder
import tech.thdev.androidrecyclerview.adapter.model.MainAdapterContract
import tech.thdev.androidrecyclerview.data.MainItem
import tech.thdev.androidrecyclerview.listener.OnItemClickListener
import tech.thdev.support.widget.adapter.BaseSimpleRecyclerAdapter
import tech.thdev.support.widget.adapter.BaseViewTypeRecyclerAdapter
import tech.thdev.support.widget.adapter.view.BaseRecyclerViewHolder

/**
 * Created by Tae-hwan on 11/10/2016.
 */

class MainListAdapterSimple(context: Context) :
        BaseViewTypeRecyclerAdapter<MainItem>(context), MainAdapterContract.Model, MainAdapterContract.View {

    var onClickListener: OnItemClickListener? = null
        private set

    fun setOnClickListener(listener: (BaseSimpleRecyclerAdapter<*>, Int) -> Unit) {
        onClickListener = object : OnItemClickListener {
            override fun onItemClick(view: BaseSimpleRecyclerAdapter<*>, position: Int) {
                listener(view, position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseRecyclerViewHolder<MainItem> {
        return MainListViewHolder(parent, MainListAdapter@this)
    }

    override fun reload() {
        notifyDataSetChanged()
    }
}