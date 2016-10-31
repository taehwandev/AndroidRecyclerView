package tech.thdev.support.widget.adapter.header_footer

import android.content.Context
import tech.thdev.support.widget.data.BaseItem

/**
 * Created by Tae-hwan on 24/10/2016.
 */

abstract class BaseHeaderFooterTypedefRecyclerAdapter<
        ITEM : BaseItem, HEADER, FOOTER>(context: Context) :
        BaseHeaderFooterRecyclerAdapter<ITEM, HEADER, FOOTER>(context) {

    override fun onItemViewType(position: Int)
            = getItem(getRealItemPosition(position))?.let { it.viewType } ?: -1
}