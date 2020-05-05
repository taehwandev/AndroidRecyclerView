package tech.thdev.androidrecyclerview.ui.custom_scroll.basic.presenter

import tech.thdev.base.presenter.BasePresenter
import tech.thdev.base.presenter.BaseView

/**
 * Created by Tae-hwan on 18/10/2016.
 */
interface BasicCustomScrollContract {
    interface View : BaseView {
        fun showProgress()
        fun hideProgress()
        fun loadFail()
    }

    interface Presenter : BasePresenter<View> {
        fun updateImage()
    }
}