package tech.thdev.androidrecyclerview.adapter.hfsample.holder

import android.graphics.BitmapFactory
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import tech.thdev.androidrecyclerview.R
import tech.thdev.androidrecyclerview.data.Image
import tech.thdev.support.widget.adapter.simple.holder.BaseViewHolder

/**
 * Created by Tae-hwan on 31/10/2016.
 */

class ImageHFViewHolder(parent: ViewGroup?, adapter: RecyclerView.Adapter<*>) :
        BaseViewHolder<Image>(R.layout.item_large_view, parent, adapter) {

    private val imageLarge by lazy {
        itemView?.findViewById(R.id.img_large) as ImageView
    }

    private val tvTitle by lazy {
        itemView?.findViewById(R.id.tv_title) as TextView
    }

    private val tvMessage by lazy {
        itemView?.findViewById(R.id.tv_message) as TextView
    }

    override fun onViewHolder(item: Image?, position: Int) {
        item?.let {
            Observable.just(it)
                    .subscribeOn(Schedulers.newThread())
                    .map {
                        BitmapFactory.decodeResource(context?.resources, it!!.img)
                    }
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        imageLarge.setImageBitmap(it)
                    }

            tvTitle.text = it.title
            tvMessage.text = it.message
        }
    }
}
