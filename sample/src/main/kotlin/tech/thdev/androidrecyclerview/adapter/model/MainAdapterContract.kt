package tech.thdev.androidrecyclerview.adapter.model

import tech.thdev.androidrecyclerview.data.MainItem
import tech.thdev.support.widget.adapter.model.BaseRecyclerModel

/**
 * Created by Tae-hwan on 11/10/2016.
 */

interface MainAdapterContract {

    interface View {
        fun reload()
    }

    interface Model : BaseRecyclerModel<MainItem> {

    }
}