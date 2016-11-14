package tech.thdev.support.widget.adapter.model

/**
 * Created by Tae-hwan on 10/10/2016.
 *
 * RecyclerView.Adapter model definition
 */

interface BaseRecyclerModel<ITEM> {

    /**
     * Item add
     */
    fun addItem(item: ITEM)

    fun addItem(position: Int, item: ITEM)

    fun addItems(items: List<ITEM>)

    /**
     * Get item
     */
    fun getItem(position: Int): ITEM?

    fun getItems(): List<ITEM>

    /**
     * Remove item
     */
    fun removeItem(item: ITEM)

    fun removeItem(position: Int)

    /**
     * Clear
     */
    fun clear()

    /**
     * Item count return
     */
    fun getItemCount(): Int
}