package tech.thdev.androidrecyclerview.ui.main.presenter

import android.content.Context
import android.content.Intent
import tech.thdev.base.presenter.BasePresenter
import tech.thdev.base.presenter.BaseView

/**
 * Created by Tae-hwan on 11/10/2016.
 */
interface SampleListContract {

    interface View : BaseView {

        fun changeActivity(intent: Intent)
    }

    interface Presenter : BasePresenter<View> {

        fun getSampleList(prefix: String?, context: Context)
    }
}