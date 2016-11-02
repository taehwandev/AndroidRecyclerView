package tech.thdev.androidrecyclerview.view.header_footer.basic.presenter

import tech.thdev.androidrecyclerview.adapter.header_footer.model.ImageHFAdapterContract
import tech.thdev.androidrecyclerview.data.source.image.ImagesRepository
import tech.thdev.base.presenter.BasePresenter
import tech.thdev.base.presenter.BaseView

/**
 * Created by Tae-hwan on 17/10/2016.
 */

interface ImageHFContract {

    interface View : BaseView {

        fun loadSuccess()

        fun loadFail()
    }

    interface Presenter : BasePresenter<View> {

        var listContractView: ImageHFAdapterContract.View?
        var listContractModel: ImageHFAdapterContract.Model?

        var imageRepository: ImagesRepository?

        fun loadImageList()

        fun addHeaderImageList()

        fun addFooterItem()
    }
}