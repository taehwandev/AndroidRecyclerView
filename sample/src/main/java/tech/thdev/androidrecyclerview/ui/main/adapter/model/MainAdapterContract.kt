package tech.thdev.androidrecyclerview.ui.main.adapter.model

import tech.thdev.androidrecyclerview.data.PrefixItem
import tech.thdev.support.widget.adapter.model.BaseRecyclerModel
import tech.thdev.support.widget.adapter.model.BaseRecyclerView

/**
 * Created by Tae-hwan on 11/10/2016.
 */
interface MainAdapterContract {

    interface View : BaseRecyclerView

    interface Model : BaseRecyclerModel<PrefixItem>
}