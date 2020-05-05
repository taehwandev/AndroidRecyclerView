package tech.thdev.androidrecyclerview.ui.basic.mvp.presenter

import tech.thdev.base.presenter.BasePresenter
import tech.thdev.base.presenter.BaseView

/**
 * Created by Tae-hwan on 11/10/2016.
 */
interface BasicMVPContract {
    interface View : BaseView {
        fun showToast(item: String)
    }

    interface Presenter : BasePresenter<View> {
        fun loadList(count: Int)
    }
}