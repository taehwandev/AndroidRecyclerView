package tech.thdev.androidrecyclerview.data.source.github

import io.reactivex.rxjava3.core.Flowable
import tech.thdev.androidrecyclerview.data.GitHubUserSearchItem

/**
 * Created by Tae-hwan on 08/11/2016.
 */

interface GitHubUserDataSource {

    fun searchUser(userName: String, page: Int, perPage: Int): Flowable<List<GitHubUserSearchItem>>
}