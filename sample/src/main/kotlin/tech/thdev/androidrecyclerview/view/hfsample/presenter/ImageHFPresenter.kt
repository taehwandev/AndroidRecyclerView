package tech.thdev.androidrecyclerview.view.hfsample.presenter

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import tech.thdev.androidrecyclerview.adapter.hfsample.model.ImageHFAdapterContract
import tech.thdev.androidrecyclerview.data.FlipItems
import tech.thdev.androidrecyclerview.data.source.image.ImagesRepository
import tech.thdev.base.presenter.AbstractPresenter

/**
 * Created by Tae-hwan on 17/10/2016.
 */

class ImageHFPresenter : AbstractPresenter<ImageHFContract.View>(), ImageHFContract.Presenter {

    override var listContractView: ImageHFAdapterContract.View? = null
    override var listContractModel: ImageHFAdapterContract.Model? = null

    override var imageRepository: ImagesRepository? = null

    override fun loadImageList() {
        imageRepository?.getAllImages()
                ?.flatMapIterable { it }
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.doOnComplete {
                    listContractView?.reload()
                    view?.loadSuccess()
                }
                ?.subscribe {
                    listContractModel?.addItem(it)
                }
    }

    override fun addHeaderImageList() {
        imageRepository?.getAllImages()
                ?.subscribeOn(Schedulers.io())
                ?.map(::FlipItems)
                ?.subscribe {
                    listContractModel?.headerItem = it
                }
        listContractView?.reload()
    }

    override fun addFooterItem() {
        listContractModel?.footerItem = null
        listContractView?.reload()
    }
}