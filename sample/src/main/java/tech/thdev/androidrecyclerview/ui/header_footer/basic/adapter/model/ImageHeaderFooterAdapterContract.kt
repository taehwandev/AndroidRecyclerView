package tech.thdev.androidrecyclerview.ui.header_footer.basic.adapter.model

import tech.thdev.androidrecyclerview.data.FlipItems
import tech.thdev.androidrecyclerview.data.Image
import tech.thdev.support.widget.adapter.header_footer.model.BaseHeaderFooterRecyclerModel

/**
 * Created by Tae-hwan on 25/10/2016.
 */
interface ImageHeaderFooterAdapterContract {

    interface View {
        fun reload()
    }

    interface Model : BaseHeaderFooterRecyclerModel<Image, FlipItems, Any> {

    }
}