package tech.thdev.androidrecyclerview.adapter.holder

import android.graphics.BitmapFactory
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import tech.thdev.androidrecyclerview.R
import tech.thdev.androidrecyclerview.data.Image
import tech.thdev.support.widget.adapter.simple.BaseTypedefRecyclerAdapter
import tech.thdev.support.widget.adapter.AbstractRecyclerAdapter
import tech.thdev.support.widget.adapter.simple.BaseSimpleRecyclerAdapter
import tech.thdev.support.widget.adapter.simple.holder.BaseViewHolder

/**
 * Created by Tae-hwan on 17/10/2016.
 */

class ImageLargeViewHolder(parent: ViewGroup?, adapterSimple: BaseSimpleRecyclerAdapter<Image>) :
        BaseViewHolder<Image>(R.layout.item_large_view, parent, adapterSimple) {

    private val image by lazy {
        itemView?.findViewById(R.id.img_large) as ImageView
    }

    private val tvTitle by lazy {
        itemView?.findViewById(R.id.tv_title) as TextView
    }

    private val tvMessage by lazy {
        itemView?.findViewById(R.id.tv_message) as TextView
    }

    override fun onViewHolder(item: Image, position: Int) {
        Observable.just(item)
                .subscribeOn(Schedulers.newThread())
                .map {
                    BitmapFactory.decodeResource(context.resources, it.img)
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    image.setImageBitmap(it)
                }
        tvTitle.text = item.title
        tvMessage.text = item.message
    }
}