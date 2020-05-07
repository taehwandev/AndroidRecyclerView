package tech.thdev.androidrecyclerview.ui.local_image.presenter

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import tech.thdev.androidrecyclerview.data.source.image.ImagesRepository
import tech.thdev.androidrecyclerview.ui.local_image.adapter.model.LocalImageAdapterContract
import tech.thdev.base.presenter.CommonPresenter

/**
 * Created by Tae-hwan on 17/10/2016.
 */

class LocalImagePresenter(
    private val listContractView: LocalImageAdapterContract.View,
    private val listContractModel: LocalImageAdapterContract.Model,
    private val imageRepository: ImagesRepository
) : CommonPresenter<LocalImageContract.View>(), LocalImageContract.Presenter {

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