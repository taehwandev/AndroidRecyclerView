package tech.thdev.androidrecyclerview.ui.design.local_image.presenter

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import tech.thdev.androidrecyclerview.data.source.image.ImagesRepository
import tech.thdev.androidrecyclerview.ui.design.local_image.adapter.model.ImageAdapterContract
import tech.thdev.base.presenter.CommonPresenter

/**
 * Created by Tae-hwan on 17/10/2016.
 */

class ImageListPresenter(
    private val listContractView: ImageAdapterContract.View,
    private val listContractModel: ImageAdapterContract.Model,
    private val imageRepository: ImagesRepository
) : CommonPresenter<ImageListContract.View>(), ImageListContract.Presenter {

    override fun loadImageList() {
        imageRepository.getAllImages()
            .flatMapIterable { it }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnComplete {
                listContractView.reload()
            }
            .subscribe {
                listContractModel.addItem(it)
            }
    }
}