package tech.thdev.androidrecyclerview.view.main.adapter

import android.content.Context
import android.view.ViewGroup
import tech.thdev.androidrecyclerview.view.main.adapter.holder.MainListViewHolder
import tech.thdev.androidrecyclerview.adapter.model.MainAdapterContract
import tech.thdev.androidrecyclerview.data.PrefixItem
import tech.thdev.support.widget.adapter.simple.BaseTypedefRecyclerAdapter
import tech.thdev.support.widget.adapter.simple.holder.BaseViewHolder

/**
 * Created by Tae-hwan on 11/10/2016.
 */

class MainListAdapter(context: Context) :
        BaseTypedefRecyclerAdapter<PrefixItem>(context), MainAdapterContract.Model, MainAdapterContract.View {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder<PrefixItem> {
        return MainListViewHolder(parent, this)
    }
}