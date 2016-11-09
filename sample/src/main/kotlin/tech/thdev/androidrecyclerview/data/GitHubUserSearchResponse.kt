package tech.thdev.androidrecyclerview.data

/**
 * Created by Tae-hwan on 09/11/2016.
 */

data class GitHubUserSearchResponse(val message: String?,
                                    val documentation_url: String?,
                                    val total_count: String?,
                                    val incomplete_results: Boolean?,
                                    val items: List<GitHubUserSearchItem>?)