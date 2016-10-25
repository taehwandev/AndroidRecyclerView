package tech.thdev.androidrecyclerview.adapter.main

import android.content.Context
import android.view.ViewGroup
import tech.thdev.androidrecyclerview.adapter.main.holder.MainListViewHolder
import tech.thdev.androidrecyclerview.adapter.model.MainAdapterContract
import tech.thdev.androidrecyclerview.data.MainItem
import tech.thdev.androidrecyclerview.listener.OnItemClickListener
import tech.thdev.support.widget.adapter.PrivateRecyclerAdapter
import tech.thdev.support.widget.adapter.simple.BaseTypedefRecyclerAdapter
import tech.thdev.support.widget.adapter.simple.holder.BaseViewHolder

/**
 * Created by Tae-hwan on 11/10/2016.
 */

class MainListAdapter(context: Context) :
        BaseTypedefRecyclerAdapter<MainItem>(context), MainAdapterContract.Model, MainAdapterContract.View {

    var onClickListener: OnItemClickListener? = null
        private set

    fun setOnClickListener(listener: (BaseTypedefRecyclerAdapter<*>, Int) -> Unit) {
        onClickListener = object : OnItemClickListener {
            override fun onItemClick(view: BaseTypedefRecyclerAdapter<*>, position: Int) {
                listener(view, position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder<MainItem> {
        return MainListViewHolder(parent, MainListAdapter@this)
    }

    override fun reload() {
        notifyDataSetChanged()
    }
}