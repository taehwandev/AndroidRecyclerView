package tech.thdev.support.widget.adapter.header_footer

import tech.thdev.support.widget.data.BaseItem

/**
 * Created by Tae-hwan on 24/10/2016.
 */
abstract class BaseHeaderFooterTypedefRecyclerAdapter<ITEM : BaseItem, HEADER, FOOTER>
    : BaseHeaderFooterRecyclerAdapter<ITEM, HEADER, FOOTER>() {

    override fun onItemViewType(position: Int) =
        getItem(getRealItemPosition(position))?.viewType ?: -1
}