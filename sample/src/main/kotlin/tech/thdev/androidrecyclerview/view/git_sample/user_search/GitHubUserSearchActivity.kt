package tech.thdev.androidrecyclerview.view.git_sample.user_search

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_git_hub_user_search.*
import tech.thdev.androidrecyclerview.R
import tech.thdev.base.util.replaceContentFragment
import tech.thdev.base.view.BaseActivity

/**
 * Created by Tae-hwan on 09/11/2016.
 */

class GitHubUserSearchActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_git_hub_user_search)

        setSupportActionBar(toolbar)
        setTitle(R.string.label_activity_network_github_kotlin)

        replaceContentFragment(R.id.frame_layout, GitHubUserSearchFragment())
    }
}