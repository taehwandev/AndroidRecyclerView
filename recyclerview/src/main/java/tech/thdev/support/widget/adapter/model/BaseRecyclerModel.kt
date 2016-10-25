package tech.thdev.support.widget.adapter.model

/**
 * Created by Tae-hwan on 10/10/2016.
 */

interface BaseRecyclerModel<ITEM> {

    fun addItem(item: ITEM)

    fun addItem(position: Int, item: ITEM)

    fun addItems(items: List<ITEM>)

    fun clear()

    fun removeItem(item: ITEM)

    fun removeItem(position: Int)

    fun getItem(position: Int): ITEM?

    fun getItemRealCount(): Int
}