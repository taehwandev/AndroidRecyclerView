package tech.thdev.androidrecyclerview.ui.github.presenter

import tech.thdev.base.presenter.BasePresenter
import tech.thdev.base.presenter.BaseView

/**
 * Created by Tae-hwan on 09/11/2016.
 */
interface GitHubUserSearchContract {

    interface View : BaseView {

        fun showProgress()

        fun hideProgress()
        fun showDetailUserInfo(html_url: String)
    }

    interface Presenter : BasePresenter<View> {

        fun searchGitHubUser(name: String)
    }
}