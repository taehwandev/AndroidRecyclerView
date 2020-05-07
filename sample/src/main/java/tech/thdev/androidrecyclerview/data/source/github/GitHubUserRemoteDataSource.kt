package tech.thdev.androidrecyclerview.data.source.github

import io.reactivex.rxjava3.core.Flowable
import tech.thdev.androidrecyclerview.data.GitHubUserSearchItem
import tech.thdev.androidrecyclerview.network.GitHubInterface
import tech.thdev.androidrecyclerview.network.createRetrofit

/**
 * Created by Tae-hwan on 09/11/2016.
 */

class GitHubUserRemoteDataSource : GitHubUserDataSource {

    private val gitHubInterface: GitHubInterface =
        createRetrofit(GitHubInterface::class.java, "https://api.github.com/")

    override fun searchUser(
        userName: String,
        page: Int,
        perPage: Int
    ): Flowable<List<GitHubUserSearchItem>> {
        return gitHubInterface.searchUser(userName, page, perPage)
            .flatMap {
                it.items?.let { items ->
                    Flowable.just(items)
                } ?: Flowable.just(mutableListOf())
            }
    }
}