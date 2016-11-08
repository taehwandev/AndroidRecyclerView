package tech.thdev.androidrecyclerview.network

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Tae-hwan on 08/11/2016.
 */

interface GitHubInterface {

    // https://api.github.com/search/users?q=tom+repos:%3E42&page=3&per_page=50
    @GET("/search/users?")
    fun searchUser(
            @Query(value = "q", encoded = true) userKeyword: String,
            @Query("page") page: Int,
            @Query("per_page") perPage: Int): Observable<GitHubUser>
}