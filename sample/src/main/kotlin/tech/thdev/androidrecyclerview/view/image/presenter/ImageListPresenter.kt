package tech.thdev.androidrecyclerview.view.image.presenter

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import tech.thdev.androidrecyclerview.adapter.model.ImageAdapterContract
import tech.thdev.androidrecyclerview.data.source.image.ImagesRepository
import tech.thdev.base.presenter.AbstractPresenter

/**
 * Created by Tae-hwan on 17/10/2016.
 */

class ImageListPresenter : AbstractPresenter<ImageListContract.View>(), ImageListContract.Presenter {

    override var listContractView: ImageAdapterContract.View? = null
    override var listContractModel: ImageAdapterContract.Model? = null

    override var imageRepository: ImagesRepository? = null

    override fun loadImageList() {
        imageRepository?.getAllImages()
            ?.flatMapIterable { it }
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.doOnComplete {
                listContractView?.reload()
            }
            ?.subscribe {
                listContractModel?.addItem(it)
            }
    }
}