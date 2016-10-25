package tech.thdev.support.widget.adapter.simple

import android.content.Context
import tech.thdev.support.widget.data.BaseItem

/**
 * Created by Tae-hwan on 24/10/2016.
 *
 * implement ITEM: BaseItem
 */
abstract class BaseTypedefRecyclerAdapter<ITEM : BaseItem>(context: Context) : BaseSimpleRecyclerAdapter<ITEM>(context) {

    override fun getViewType(position: Int)
            = getItem(position)?.let { it.viewType } ?: -1
}