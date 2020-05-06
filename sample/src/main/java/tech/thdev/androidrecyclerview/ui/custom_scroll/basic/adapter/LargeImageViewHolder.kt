package tech.thdev.androidrecyclerview.ui.custom_scroll.basic.adapter

import android.graphics.BitmapFactory
import android.view.ViewGroup
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.item_small_image.view.*
import tech.thdev.androidrecyclerview.MyApplication
import tech.thdev.androidrecyclerview.R
import tech.thdev.androidrecyclerview.data.LocalImage
import tech.thdev.support.widget.adapter.simple.BaseTypedefRecyclerAdapter
import tech.thdev.support.widget.adapter.simple.holder.BaseViewHolder

/**
 * Created by Tae-hwan on 18/10/2016.
 */
@Deprecated("Not use.... Rx...")
class LargeImageViewHolder(
    parent: ViewGroup,
    adapter: BaseTypedefRecyclerAdapter<LocalImage>
) : BaseViewHolder<LocalImage>(R.layout.item_large_view, parent, adapter) {

    override fun onBindViewHolder(item: LocalImage?, position: Int) {
        item?.let {
            Flowable.just(item)
                .filter { it != null }
                .subscribeOn(Schedulers.io())
                .map {
                    BitmapFactory.decodeResource(
                        MyApplication.appContext.resources,
                        it!!.resource
                    )
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    itemView.image_view.setImageBitmap(it)
                }, {
                    // ...
                })
        }
    }
}