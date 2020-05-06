package tech.thdev.androidrecyclerview.ui.git_sample.presenter

import tech.thdev.androidrecyclerview.data.GitHubUserSearchItem
import tech.thdev.androidrecyclerview.data.source.github.GitHubUserRepository
import tech.thdev.base.presenter.BasePresenter
import tech.thdev.base.presenter.BaseView
import tech.thdev.support.widget.adapter.model.BaseRecyclerModel
import tech.thdev.support.widget.adapter.model.BaseRecyclerView

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