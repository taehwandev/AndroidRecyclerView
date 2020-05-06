package tech.thdev.androidrecyclerview.ui.header_footer.basic.presenter

import tech.thdev.base.presenter.BasePresenter
import tech.thdev.base.presenter.BaseView

/**
 * Created by Tae-hwan on 17/10/2016.
 */

interface ImageHeaderFooterContract {

    interface View : BaseView {

        fun loadSuccess()

        fun loadFail()
    }

    interface Presenter : BasePresenter<View> {

        fun loadImageList()

        fun addHeaderImageList()

        fun addFooterItem()
    }
}