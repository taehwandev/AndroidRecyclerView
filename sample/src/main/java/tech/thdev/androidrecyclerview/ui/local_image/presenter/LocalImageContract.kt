package tech.thdev.androidrecyclerview.ui.local_image.presenter

import tech.thdev.base.presenter.BasePresenter
import tech.thdev.base.presenter.BaseView

/**
 * Created by Tae-hwan on 17/10/2016.
 */

interface LocalImageContract {

    interface View : BaseView {

        fun loadSuccess()

        fun loadFail()
    }

    interface Presenter : BasePresenter<View> {

        fun loadImageList()
    }
}