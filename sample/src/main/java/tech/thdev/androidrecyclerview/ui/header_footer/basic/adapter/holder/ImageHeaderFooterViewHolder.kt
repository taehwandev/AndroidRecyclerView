package tech.thdev.androidrecyclerview.ui.header_footer.basic.adapter.holder

import android.graphics.BitmapFactory
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.item_large_view.view.*
import tech.thdev.androidrecyclerview.R
import tech.thdev.androidrecyclerview.data.Image
import tech.thdev.support.widget.adapter.simple.holder.BaseViewHolder

/**
 * Created by Tae-hwan on 31/10/2016.
 */
class ImageHeaderFooterViewHolder(parent: ViewGroup, adapter: RecyclerView.Adapter<*>) :
    BaseViewHolder<Image>(R.layout.item_large_view, parent, adapter) {

    override fun onBindViewHolder(item: Image?, position: Int) {
        item?.let {
            Flowable.just(it)
                .filter { it != null }
                .subscribeOn(Schedulers.newThread())
                .map {
                    BitmapFactory.decodeResource(context.resources, it!!.img)
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    itemView.img_large.setImageBitmap(it)
                }

            itemView.tv_title.text = it.title
            itemView.tv_message.text = it.message
        }
    }
}
