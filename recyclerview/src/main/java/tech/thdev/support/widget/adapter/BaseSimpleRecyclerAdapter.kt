package tech.thdev.support.widget.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import tech.thdev.support.widget.adapter.model.BaseRecyclerModel
import tech.thdev.support.widget.adapter.view.BaseRecyclerViewHolder
import java.util.*

/**
 * Created by Tae-hwan on 10/10/2016.
 *
 * Default RecyclerAdapter
 */

abstract class BaseSimpleRecyclerAdapter<ITEM>(open val context: Context) :
        RecyclerView.Adapter<BaseRecyclerViewHolder<ITEM>>(), BaseRecyclerModel<Any> {

    private val itemList: MutableList<Any> = ArrayList()

    override fun onBindViewHolder(holder: BaseRecyclerViewHolder<ITEM>?, position: Int) {
        getItem(position)
                ?.let { holder?.onViewHolder(it, position) }
                ?: holder?.onViewHolder(position)
    }


    /**
     * 해당 View
     */
    abstract fun getViewType(position: Int): Int

    override fun getItemCount() = itemList.size

    override fun getItemViewType(position: Int)
            = getViewType(position)

    override fun addItem(item: Any) {
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

    override fun getItemRealCount() = itemCount
}
