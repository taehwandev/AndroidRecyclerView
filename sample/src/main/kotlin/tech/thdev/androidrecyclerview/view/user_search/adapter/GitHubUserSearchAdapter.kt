package tech.thdev.androidrecyclerview.view.user_search.adapter

import android.content.Context
import android.view.ViewGroup
import tech.thdev.androidrecyclerview.data.GitHubUserSearchItem
import tech.thdev.androidrecyclerview.view.user_search.adapter.holder.GitHubUserViewHolder
import tech.thdev.support.widget.adapter.simple.BaseTypedefRecyclerAdapter

/**
 * Created by Tae-hwan on 09/11/2016.
 */

class GitHubUserSearchAdapter(context: Context) :
        BaseTypedefRecyclerAdapter<GitHubUserSearchItem>(context) {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) = when (viewType) {
        else -> GitHubUserViewHolder(parent, this)
    }
}