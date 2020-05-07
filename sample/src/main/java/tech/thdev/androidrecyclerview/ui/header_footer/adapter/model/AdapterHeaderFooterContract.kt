package tech.thdev.androidrecyclerview.ui.header_footer.adapter.model

import tech.thdev.support.widget.adapter.header_footer.model.BaseHeaderFooterRecyclerModel
import tech.thdev.support.widget.data.BaseItem

/**
 * Created by Tae-hwan on 01/11/2016.
 */
interface AdapterHeaderFooterContract {
    interface View {
        fun reload()
    }

    interface Model<ITEM : BaseItem, HEADER, FOOTER> :
        BaseHeaderFooterRecyclerModel<ITEM, HEADER, FOOTER> {

        val headerItemPosition: Int
        val footerItemPosition: Int
    }
}