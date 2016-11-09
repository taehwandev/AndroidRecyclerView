package tech.thdev.androidrecyclerview.data

import tech.thdev.support.widget.data.BaseItem

/**
 * Created by Tae-hwan on 09/11/2016.
 */

data class GitHubUserSearchItem(val login: String,
                                val avatar_url: String,
                                val html_url: String,
                                val score: Float,
                                override val viewType: Int) : BaseItem