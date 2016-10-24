package tech.thdev.support.widget.adapter

import android.content.Context
import tech.thdev.support.widget.data.BaseItem

/**
 * Created by Tae-hwan on 24/10/2016.
 *
 * implement ITEM: BaseItem
 */
abstract class BaseViewTypeRecyclerAdapter<ITEM : BaseItem>(context: Context) : BaseSimpleRecyclerAdapter<ITEM>(context) {

    override fun getViewType(position: Int)
            = getItem(position)?.let { it.viewType } ?: -1
}