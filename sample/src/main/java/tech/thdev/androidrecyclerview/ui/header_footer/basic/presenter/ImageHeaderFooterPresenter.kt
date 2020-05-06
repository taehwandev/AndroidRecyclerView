package tech.thdev.androidrecyclerview.ui.header_footer.basic.presenter

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import tech.thdev.androidrecyclerview.data.FlipItems
import tech.thdev.androidrecyclerview.data.source.image.ImagesRepository
import tech.thdev.androidrecyclerview.ui.header_footer.basic.adapter.model.ImageHeaderFooterAdapterContract
import tech.thdev.base.presenter.CommonPresenter

/**
 * Created by Tae-hwan on 17/10/2016.
 */
class ImageHeaderFooterPresenter(
    private val listContractView: ImageHeaderFooterAdapterContract.View,
    private val listContractModel: ImageHeaderFooterAdapterContract.Model,
    private val imageRepository: ImagesRepository
) : CommonPresenter<ImageHeaderFooterContract.View>(), ImageHeaderFooterContract.Presenter {

    override fun loadImageList() {
        imageRepository.getAllImages()
            .flatMapIterable { it }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnComplete {
                listContractView.reload()
                view?.loadSuccess()
            }
            .subscribe {
                listContractModel.addItem(it)
            }
    }

    override fun addHeaderImageList() {
        imageRepository.getAllImages()
            .subscribeOn(Schedulers.io())
            .map(::FlipItems)
            .subscribe {
                listContractModel.headerItem = it
            }
        listContractView.reload()
    }

    override fun addFooterItem() {
        listContractModel.footerItem = null
        listContractView.reload()
    }
}