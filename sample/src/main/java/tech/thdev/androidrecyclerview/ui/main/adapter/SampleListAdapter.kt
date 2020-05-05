package tech.thdev.androidrecyclerview.ui.main.adapter

import android.view.ViewGroup
import tech.thdev.androidrecyclerview.adapter.model.MainAdapterContract
import tech.thdev.androidrecyclerview.data.PrefixItem
import tech.thdev.androidrecyclerview.ui.main.adapter.holder.SampleListViewHolder
import tech.thdev.support.widget.adapter.simple.BaseTypedefRecyclerAdapter
import tech.thdev.support.widget.adapter.simple.holder.BaseViewHolder

/**
 * Created by Tae-hwan on 11/10/2016.
 */

class SampleListAdapter : BaseTypedefRecyclerAdapter<PrefixItem>(), MainAdapterContract.Model,
    MainAdapterContract.View {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<PrefixItem> {
        return SampleListViewHolder(parent, this)
    }
}