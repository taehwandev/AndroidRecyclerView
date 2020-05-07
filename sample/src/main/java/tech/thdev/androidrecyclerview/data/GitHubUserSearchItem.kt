package tech.thdev.androidrecyclerview.data

import com.google.gson.annotations.SerializedName
import tech.thdev.support.widget.data.BaseItem

/**
 * Created by Tae-hwan on 09/11/2016.
 */

data class GitHubUserSearchItem(
    @SerializedName("login") val login: String,
    @SerializedName("avatar_url") val avatarUrl: String,
    @SerializedName("html_url") val htmlUrl: String,
    @SerializedName("score") val score: Float,
    override val viewType: Int
) : BaseItem