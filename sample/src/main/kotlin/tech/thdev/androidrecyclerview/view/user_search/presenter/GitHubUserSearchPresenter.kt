package tech.thdev.androidrecyclerview.view.user_search.presenter

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import tech.thdev.androidrecyclerview.data.GitHubUserSearchItem
import tech.thdev.androidrecyclerview.data.source.github.GitHubUserRepository
import tech.thdev.base.presenter.AbstractPresenter
import tech.thdev.support.widget.adapter.model.BaseRecyclerModel
import tech.thdev.support.widget.adapter.model.BaseRecyclerView

/**
 * Created by Tae-hwan on 09/11/2016.
 */

class GitHubUserSearchPresenter : AbstractPresenter<GitHubUserSearchContract.View>(), GitHubUserSearchContract.Presenter {

    val DEFAULT_PER_PAGE = 20

    var page = 0

    override var adapterModel: BaseRecyclerModel<GitHubUserSearchItem>? = null
    override var adapterView: BaseRecyclerView? = null

    override var gitHubUserRepository: GitHubUserRepository? = null

    override fun searchGitHubUser(name: String) {
        gitHubUserRepository?.searchUser(name, ++page, DEFAULT_PER_PAGE)
                ?.subscribeOn(Schedulers.io())
                ?.flatMapIterable { it }
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.doOnSubscribe {
                    view?.showProgress()
                }
                ?.doOnComplete {
                    view?.hideProgress()
                    adapterView?.notifyDataSetChanged()
                }
                ?.observeOn(Schedulers.io())
                ?.subscribe {
                    adapterModel?.addItem(it)
                }
    }
}