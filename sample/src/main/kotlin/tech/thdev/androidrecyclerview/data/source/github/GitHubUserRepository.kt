package tech.thdev.androidrecyclerview.data.source.github

/**
 * Created by Tae-hwan on 09/11/2016.
 */

object GitHubUserRepository : GitHubUserDataSource {

    private val remoteDataSource: GitHubUserRemoteDataSource

    init {
        remoteDataSource = GitHubUserRemoteDataSource()
    }

    override fun searchUser(userName: String, page: Int, perPage: Int)
            = remoteDataSource.searchUser(userName, page, perPage)
}