package tech.thdev.androidrecyclerview.ui.custom_scroll.basic.presenter

import io.reactivex.rxjava3.schedulers.Schedulers
import tech.thdev.androidrecyclerview.ui.header_footer.custom.adapter.model.AdapterContract
import tech.thdev.androidrecyclerview.data.LocalImage
import tech.thdev.androidrecyclerview.data.source.image.ImagesMetaLocalRepository
import tech.thdev.base.presenter.CommonPresenter

/**
 * Created by Tae-hwan on 18/10/2016.
 */
class BasicCustomScrollPresenter(
    private val adapterView: AdapterContract.View,
    private val adapterModel: AdapterContract.Model<LocalImage>,
    private val metaLocalRepository: ImagesMetaLocalRepository
) : CommonPresenter<BasicCustomScrollContract.View>(),
    BasicCustomScrollContract.Presenter {

    override fun updateImage() {
        metaLocalRepository.allImages
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe(object : Consumer<Disposable?>() {
                @Throws(Exception::class)
                fun accept(disposable: Disposable?) {
                    getView().showProgress()
                }
            })
            .doOnComplete(object : Action() {
                @Throws(Exception::class)
                fun run() {
                    if (adapterView != null) {
                        adapterView!!.reload()
                    }
                    getView().hideProgress()
                }
            })
            .subscribe(object : Consumer<List<LocalImage?>?>() {
                @Throws(Exception::class)
                fun accept(localImages: List<LocalImage>?) {
                    if (adapterModel != null) {
                        adapterModel!!.addItems(localImages!!)
                    }
                }
            }, object : Consumer<Throwable?>() {
                @Throws(Exception::class)
                fun accept(throwable: Throwable?) {
                    getView().loadFail()
                }
            })
    }
}