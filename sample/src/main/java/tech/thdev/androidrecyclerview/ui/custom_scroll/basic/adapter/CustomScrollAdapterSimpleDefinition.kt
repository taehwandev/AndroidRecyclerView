package tech.thdev.androidrecyclerview.ui.custom_scroll.basic.adapter

import android.view.ViewGroup
import tech.thdev.androidrecyclerview.data.LocalImage
import tech.thdev.androidrecyclerview.ui.header_footer.custom.adapter.model.AdapterContract
import tech.thdev.support.widget.adapter.simple.BaseTypedefRecyclerAdapter
import tech.thdev.support.widget.adapter.simple.holder.BaseViewHolder

/**
 * Created by Tae-hwan on 18/10/2016.
 */
class CustomScrollAdapterSimpleDefinition : BaseTypedefRecyclerAdapter<LocalImage>(),
    AdapterContract.Model<LocalImage>, AdapterContract.View {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<LocalImage> {
        return LargeImageViewHolder(parent, this)
    }

    override fun reload() {
        notifyDataSetChanged()
    }
}
