package tech.thdev.androidrecyclerview.data.source.github

import io.reactivex.Observable

/**
 * Created by Tae-hwan on 08/11/2016.
 */

interface GitHubUserSource {

    fun searchUser(userName: String): Observable<>
}