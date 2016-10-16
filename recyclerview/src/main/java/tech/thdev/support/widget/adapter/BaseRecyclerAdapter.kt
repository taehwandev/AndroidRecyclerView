package tech.thdev.support.widget.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import tech.thdev.support.widget.adapter.model.BaseRecyclerModel
import tech.thdev.support.widget.adapter.open.OpenBaseViewHolder
import tech.thdev.support.widget.data.BaseItem
import java.util.*

/**
 * Created by Tae-hwan on 10/10/2016.
 */

abstract class BaseRecyclerAdapter<ITEM : BaseItem>(val context: Context)
    : RecyclerView.Adapter<OpenBaseViewHolder<ITEM>>(), BaseRecyclerModel<ITEM> {

    private val itemList: MutableList<ITEM> = ArrayList()

    override fun onBindViewHolder(holder: OpenBaseViewHolder<ITEM>?, position: Int) {
        getItem(position)
                ?.let { holder?.onViewHolder(it, position) }
                ?: holder?.onViewHolder(position)
    }

    override fun getItemCount() = itemList.size

    override fun getItemViewType(position: Int)
            = getItem(position)?.viewType ?: super.getItemViewType(position)

    override fun addItem(item: ITEM) {
        itemList.add(item)
    }

    override fun addItem(position: Int, item: ITEM) {
        itemList.add(position, item)
    }

    override fun addItems(items: List<ITEM>) {
        itemList.addAll(items)
    }

    override fun clear() {
        itemList.clear()
    }

    override fun removeItem(item: ITEM) {
        itemList.remove(item)
    }

    override fun removeItem(position: Int) {
        itemList.removeAt(position)
    }

    override fun getItem(position: Int): ITEM? = itemList[position]

    override fun getCount() = itemCount
}