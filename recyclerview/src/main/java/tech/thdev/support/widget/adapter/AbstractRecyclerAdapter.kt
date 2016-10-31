package tech.thdev.support.widget.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import tech.thdev.support.widget.adapter.simple.model.BaseRecyclerModel
import java.util.*

/**
 * Created by Tae-hwan on 10/10/2016.
 *
 * Default RecyclerAdapter
 */

abstract class AbstractRecyclerAdapter<ITEM, VIEW_TYPE : RecyclerView.ViewHolder?>(open val context: Context) :
        RecyclerView.Adapter<VIEW_TYPE>(), BaseRecyclerModel<ITEM> {

    private val itemList: MutableList<ITEM> = ArrayList()

    abstract fun onItemViewType(position: Int): Int

    override fun getItemViewType(position: Int)
            = onItemViewType(position)

    override fun getItemCount()
            = itemList.size

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

    /**
     * GetItem null or ITEM
     */
    override fun getItem(position: Int)
            = itemList.getOrNull(position)

    override fun getItems() = itemList
}
