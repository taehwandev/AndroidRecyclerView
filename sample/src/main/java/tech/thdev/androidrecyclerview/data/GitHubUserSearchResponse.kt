package tech.thdev.androidrecyclerview.data

import com.google.gson.annotations.SerializedName

/**
 * Created by Tae-hwan on 09/11/2016.
 */

data class GitHubUserSearchResponse(
    @SerializedName("message") val message: String?,
    @SerializedName("documentation_url") val documentationUrl: String?,
    @SerializedName("total_count") val totalCount: String?,
    @SerializedName("incomplete_results") val incompleteResults: Boolean?,
    @SerializedName("items") val items: List<GitHubUserSearchItem>?
)