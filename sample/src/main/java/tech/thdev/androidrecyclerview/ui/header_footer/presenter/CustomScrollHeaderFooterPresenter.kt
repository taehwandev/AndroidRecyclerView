package tech.thdev.androidrecyclerview.ui.header_footer.presenter

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import tech.thdev.androidrecyclerview.ui.header_footer.adapter.model.AdapterHeaderFooterContract
import tech.thdev.androidrecyclerview.data.LocalImage
import tech.thdev.androidrecyclerview.data.source.image.ImagesMetaLocalRepository
import tech.thdev.base.presenter.CommonPresenter
import java.util.*

/**
 * Created by Tae-hwan on 18/10/2016.
 */
class CustomScrollHeaderFooterPresenter(
    private val adapterView: AdapterHeaderFooterContract.View,
    private val adapterModel: AdapterHeaderFooterContract.Model<LocalImage, LocalImage, Objects>,
    private val metaLocalRepository: ImagesMetaLocalRepository
) :
    CommonPresenter<CustomScrollHeaderFooterContract.View>(),
    CustomScrollHeaderFooterContract.Presenter {

    override fun loadImage() {
        metaLocalRepository.getAllImages()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                view?.showProgress()
            }
            .doOnComplete {
                adapterView.reload()
                view?.hideProgress()
            }
            .subscribe({
                adapterModel.addItems(it)
            }, {
                view?.loadFail()
            })
    }

    override fun loadHeader() {
        adapterModel.headerItem = null
    }

    override fun loadFooter() {
        adapterModel.footerItem = null
    }
}