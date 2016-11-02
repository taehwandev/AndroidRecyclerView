package tech.thdev.support.widget.adapter.header_footer.model

import tech.thdev.support.widget.adapter.simple.model.BaseRecyclerModel

/**
 * Created by Tae-hwan on 26/10/2016.
 */
interface BaseHeaderFooterRecyclerModel<ITEM, HEADER, FOOTER> : BaseRecyclerModel<ITEM> {

    var headerItem: HEADER?

    var footerItem: FOOTER?

    /**
     * Count except header/footer
     */
    fun getRealItemCount(): Int

    fun hasHeaderItems(position: Int): Boolean

    fun hasFooterItem(position: Int): Boolean
}