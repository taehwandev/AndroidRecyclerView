package tech.thdev.androidrecyclerview.ui.header_footer.adapter.model

import tech.thdev.support.widget.adapter.model.BaseRecyclerModel
import tech.thdev.support.widget.data.BaseItem

/**
 * Created by Tae-hwan on 10/10/2016.
 */
interface AdapterContract {
    interface View {
        fun reload()
    }

    interface Model<T : BaseItem> : BaseRecyclerModel<T>
}