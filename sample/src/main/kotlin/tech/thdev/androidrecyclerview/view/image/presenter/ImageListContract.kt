package tech.thdev.androidrecyclerview.view.image.presenter

import tech.thdev.androidrecyclerview.adapter.model.ImageAdapterContract
import tech.thdev.androidrecyclerview.data.source.image.ImagesRepository
import tech.thdev.base.presenter.BasePresenter
import tech.thdev.base.presenter.BaseView

/**
 * Created by Tae-hwan on 17/10/2016.
 */

interface ImageListContract {

    interface View : BaseView {

        fun loadSuccess()

        fun loadFail()
    }

    interface Presenter : BasePresenter<View> {

        var listContractView: ImageAdapterContract.View?
        var listContractModel: ImageAdapterContract.Model?

        var imageRepository: ImagesRepository?

        fun loadImageList()
    }
}