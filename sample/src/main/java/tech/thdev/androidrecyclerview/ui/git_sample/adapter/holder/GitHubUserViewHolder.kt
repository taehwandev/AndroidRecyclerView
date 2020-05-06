package tech.thdev.androidrecyclerview.ui.git_sample.adapter.holder

import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_git_hub_user.view.*
import tech.thdev.androidrecyclerview.R
import tech.thdev.androidrecyclerview.data.GitHubUserSearchItem
import tech.thdev.androidrecyclerview.ui.git_sample.adapter.GitHubUserSearchAdapter
import tech.thdev.support.widget.adapter.simple.holder.BaseViewHolder

/**
 * Created by Tae-hwan on 09/11/2016.
 */

class GitHubUserViewHolder(parent: ViewGroup, adapter: GitHubUserSearchAdapter) :
    BaseViewHolder<GitHubUserSearchItem>(R.layout.item_git_hub_user, parent, adapter) {

    init {
        itemView.setOnClickListener {
            onItemClick?.onItemClick(adapter, adapterPosition)
        }
    }

    override fun onBindViewHolder(item: GitHubUserSearchItem?, position: Int) {
        Glide.with(context)
            .load(item?.avatarUrl ?: "")
            .centerCrop()
            .into(itemView.image_view)

        itemView.tv_user_name.text = item?.login
    }
}