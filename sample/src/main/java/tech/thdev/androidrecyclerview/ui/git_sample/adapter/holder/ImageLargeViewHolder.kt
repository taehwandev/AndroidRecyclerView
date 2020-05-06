package tech.thdev.androidrecyclerview.ui.git_sample.adapter.holder

import android.graphics.BitmapFactory
import android.view.ViewGroup
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.item_large_view.view.*
import tech.thdev.androidrecyclerview.R
import tech.thdev.androidrecyclerview.data.Image
import tech.thdev.support.widget.adapter.simple.BaseSimpleRecyclerAdapter
import tech.thdev.support.widget.adapter.simple.holder.BaseViewHolder

/**
 * Created by Tae-hwan on 17/10/2016.
 */

class ImageLargeViewHolder(parent: ViewGroup, adapterSimple: BaseSimpleRecyclerAdapter<Image>) :
        BaseViewHolder<Image>(R.layout.item_large_view, parent, adapterSimple) {

    override fun onBindViewHolder(item: Image?, position: Int) {
        Flowable.just(item)
                .subscribeOn(Schedulers.newThread())
                .filter { item != null }
                .map {
                    BitmapFactory.decodeResource(context?.resources, it!!.img)
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    itemView.img_large.setImageBitmap(it)
                }

        itemView.tv_title.text = item?.title
        itemView.tv_message.text = item?.message
    }
}