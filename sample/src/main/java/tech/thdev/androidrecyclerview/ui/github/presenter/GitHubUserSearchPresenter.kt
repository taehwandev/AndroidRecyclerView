package tech.thdev.androidrecyclerview.ui.github.presenter

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import tech.thdev.androidrecyclerview.data.GitHubUserSearchItem
import tech.thdev.androidrecyclerview.data.source.github.GitHubUserRepository
import tech.thdev.base.presenter.CommonPresenter
import tech.thdev.support.widget.adapter.model.BaseRecyclerModel
import tech.thdev.support.widget.adapter.model.BaseRecyclerView

/**
 * Created by Tae-hwan on 09/11/2016.
 */

class GitHubUserSearchPresenter(
    private val adapterModel: BaseRecyclerModel<GitHubUserSearchItem>,
    private val adapterView: BaseRecyclerView,
    private val gitHubUserRepository: GitHubUserRepository
) : CommonPresenter<GitHubUserSearchContract.View>(),
    GitHubUserSearchContract.Presenter {

    companion object {
        const val DEFAULT_PER_PAGE = 20
    }

    private var page = 0

    init {
        adapterView.setOnItemClickListener { _, i ->
            onListItemClick(i)
        }
    }

    override fun searchGitHubUser(name: String) {
        gitHubUserRepository.searchUser(name, ++page, DEFAULT_PER_PAGE)
            .subscribeOn(Schedulers.io())
            .flatMapIterable { it }
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                view?.showProgress()
            }
            .doOnComplete {
                view?.hideProgress()
                adapterView.notifyDataSetChanged()
            }
            .observeOn(Schedulers.io())
            .subscribe {
                adapterModel.addItem(it)
            }
    }

    private fun onListItemClick(position: Int) {
        val item = adapterModel.getItem(position)
        item?.htmlUrl?.let {
            view?.showDetailUserInfo(it)
        }
    }
}