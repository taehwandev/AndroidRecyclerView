package tech.thdev.support.widget.adapter

import android.content.Context
import tech.thdev.support.widget.data.BaseItem

/**
 * Created by Tae-hwan on 24/10/2016.
 */

abstract class BaseViewTypeHFRecyclerAdapter<ITEM : BaseItem>(context: Context) : BaseHFRecyclerAdapter<ITEM>(context) {

    override fun getViewType(position: Int) = getItem(position)?.let { it.viewType } ?: -1
}