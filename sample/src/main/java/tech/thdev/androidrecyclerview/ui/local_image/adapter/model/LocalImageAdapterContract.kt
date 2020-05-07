package tech.thdev.androidrecyclerview.ui.local_image.adapter.model

import tech.thdev.androidrecyclerview.data.Image
import tech.thdev.support.widget.adapter.model.BaseRecyclerModel

/**
 * Created by Tae-hwan on 17/10/2016.
 */

interface LocalImageAdapterContract {

    interface View {
        fun reload()
    }

    interface Model : BaseRecyclerModel<Image> {

    }
}