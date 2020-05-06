package tech.thdev.androidrecyclerview.ui.custom_scroll.basic.presenter

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import tech.thdev.androidrecyclerview.data.LocalImage
import tech.thdev.androidrecyclerview.data.source.image.ImagesMetaLocalRepository
import tech.thdev.androidrecyclerview.ui.header_footer.custom.adapter.model.AdapterContract
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
}