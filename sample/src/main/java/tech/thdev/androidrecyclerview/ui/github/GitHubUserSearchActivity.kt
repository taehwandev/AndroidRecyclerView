package tech.thdev.androidrecyclerview.ui.github

import android.os.Bundle
import tech.thdev.androidrecyclerview.R
import tech.thdev.androidrecyclerview.databinding.ActivityGitHubUserSearchBinding
import tech.thdev.base.ui.BaseActivity
import tech.thdev.base.util.replaceContentFragment

/**
 * Created by Tae-hwan on 09/11/2016.
 */

class GitHubUserSearchActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityGitHubUserSearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        replaceContentFragment(R.id.frame_layout, GitHubUserSearchFragment.newInstance())
    }
}