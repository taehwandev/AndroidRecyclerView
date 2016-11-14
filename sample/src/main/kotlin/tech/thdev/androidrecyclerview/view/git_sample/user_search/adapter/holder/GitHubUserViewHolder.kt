package tech.thdev.androidrecyclerview.view.git_sample.user_search.adapter.holder

import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_git_hub_user.view.*
import tech.thdev.androidrecyclerview.R
import tech.thdev.androidrecyclerview.data.GitHubUserSearchItem
import tech.thdev.androidrecyclerview.view.git_sample.user_search.adapter.GitHubUserSearchAdapter
import tech.thdev.support.widget.adapter.simple.holder.BaseViewHolder

/**
 * Created by Tae-hwan on 09/11/2016.
 */

class GitHubUserViewHolder(parent: ViewGroup?, adapter: GitHubUserSearchAdapter) :
        BaseViewHolder<GitHubUserSearchItem>(R.layout.item_git_hub_user, parent, adapter) {

    override fun onBindViewHolder(item: GitHubUserSearchItem?, position: Int) {
        itemView?.let {
            with(it) {
                Glide.with(context)
                        .load(item?.avatar_url ?: "")
                        .centerCrop()
                        .into(image_view)

                tv_user_name.text = item?.login
            }

            it.setOnClickListener { onItemClick?.onItemClick(adapter, position) }
        }
    }
}