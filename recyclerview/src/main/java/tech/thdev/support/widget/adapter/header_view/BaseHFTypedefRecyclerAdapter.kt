package tech.thdev.support.widget.adapter.header_view

import android.content.Context
import tech.thdev.support.widget.data.BaseItem

/**
 * Created by Tae-hwan on 24/10/2016.
 */

abstract class BaseHFTypedefRecyclerAdapter<
        ITEM : BaseItem, HEADER, FOOTER>(context: Context) :
        BaseHFRecyclerAdapter<ITEM, HEADER, FOOTER>(context) {

    override fun getViewType(position: Int) = getItem(position)?.let { it.viewType } ?: -1
}