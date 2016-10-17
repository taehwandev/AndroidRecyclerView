package tech.thdev.androidrecyclerview.adapter

import android.content.Context
import android.view.ViewGroup
import tech.thdev.androidrecyclerview.adapter.holder.MainListViewHolder
import tech.thdev.androidrecyclerview.adapter.model.MainAdapterContract
import tech.thdev.androidrecyclerview.data.MainItem
import tech.thdev.androidrecyclerview.listener.OnItemClickListener
import tech.thdev.support.widget.adapter.BaseRecyclerAdapter
import tech.thdev.support.widget.adapter.view.BaseRecyclerViewHolder

/**
 * Created by Tae-hwan on 11/10/2016.
 */

class MainListAdapter(context: Context) :
        BaseRecyclerAdapter<MainItem>(context), MainAdapterContract.Model, MainAdapterContract.View {

    var onClickListener: OnItemClickListener? = null
        private set

    fun setOnClickListener(listener: (BaseRecyclerAdapter<*>, Int) -> Unit) {
        onClickListener = object : OnItemClickListener {
            override fun onItemClick(view: BaseRecyclerAdapter<*>, position: Int) {
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