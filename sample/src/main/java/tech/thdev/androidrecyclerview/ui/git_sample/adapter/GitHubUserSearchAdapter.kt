package tech.thdev.androidrecyclerview.ui.git_sample.adapter

import android.view.ViewGroup
import tech.thdev.androidrecyclerview.data.GitHubUserSearchItem
import tech.thdev.androidrecyclerview.ui.git_sample.adapter.holder.GitHubUserViewHolder
import tech.thdev.support.widget.adapter.simple.BaseTypedefRecyclerAdapter
import tech.thdev.support.widget.adapter.simple.holder.BaseViewHolder

/**
 * Created by Tae-hwan on 09/11/2016.
 */

class GitHubUserSearchAdapter : BaseTypedefRecyclerAdapter<GitHubUserSearchItem>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<GitHubUserSearchItem> {
        return GitHubUserViewHolder(parent, this)
    }
}