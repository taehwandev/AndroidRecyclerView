package tech.thdev.androidrecyclerview.ui.header_footer.presenter

import tech.thdev.base.presenter.BasePresenter
import tech.thdev.base.presenter.BaseView

/**
 * Created by Tae-hwan on 18/10/2016.
 */
interface CustomScrollHeaderFooterContract {

    interface View : BaseView {
        fun showProgress()
        fun hideProgress()
        fun loadFail()
    }

    interface Presenter : BasePresenter<View> {
        fun loadHeader()
        fun loadFooter()
        fun loadImage()
    }
}