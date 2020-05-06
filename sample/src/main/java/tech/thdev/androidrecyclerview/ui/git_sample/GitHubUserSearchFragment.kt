package tech.thdev.androidrecyclerview.ui.git_sample

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.browser.customtabs.CustomTabsIntent
import tech.thdev.androidrecyclerview.R
import tech.thdev.androidrecyclerview.data.source.github.GitHubUserRepository
import tech.thdev.androidrecyclerview.databinding.FragmentGitHubUserSearchBinding
import tech.thdev.androidrecyclerview.ui.git_sample.adapter.GitHubUserSearchAdapter
import tech.thdev.androidrecyclerview.ui.git_sample.presenter.GitHubUserSearchContract
import tech.thdev.androidrecyclerview.ui.git_sample.presenter.GitHubUserSearchPresenter
import tech.thdev.base.ui.BasePresenterFragment

/**
 * Created by Tae-hwan on 09/11/2016.
 */
class GitHubUserSearchFragment :
    BasePresenterFragment<GitHubUserSearchContract.View, GitHubUserSearchContract.Presenter>(),
    GitHubUserSearchContract.View {

    companion object {
        private const val SEARCH_KEYWORD = "tom+repos:>42"

        fun newInstance(): GitHubUserSearchFragment =
            GitHubUserSearchFragment()
    }

    private val userSearchAdapter by lazy {
        GitHubUserSearchAdapter()
    }

    override fun onCreatePresenter() =
        GitHubUserSearchPresenter(
            userSearchAdapter,
            userSearchAdapter,
            GitHubUserRepository
        )

    private lateinit var binding: FragmentGitHubUserSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        FragmentGitHubUserSearchBinding.inflate(inflater, container, false).also {
            binding = it
        }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.root.adapter = userSearchAdapter

        presenter.searchGitHubUser(SEARCH_KEYWORD)
    }

    override fun showProgress() {
        Toast.makeText(context, "Start", Toast.LENGTH_SHORT).show()
    }

    override fun hideProgress() {
        Toast.makeText(context, "End", Toast.LENGTH_SHORT).show()
    }

    override fun showDetailUserInfo(html_url: String) {
        // Use a CustomTabsIntent.Builder to configure CustomTabsIntent.
        // Once ready, call CustomTabsIntent.Builder.build() to create a CustomTabsIntent
        // and launch the desired Url with CustomTabsIntent.launchUrl()
        val customTabsIntent = CustomTabsIntent.Builder().apply {
            // Changes the background color for the omnibox. colorInt is an int
            // that specifies a Color.
            setToolbarColor(resources.getColor(R.color.colorPrimary))
            setStartAnimations(requireContext(), 0, 0)
            setExitAnimations(requireContext(), 0, 0)
        }.build()

        customTabsIntent.launchUrl(requireContext(), Uri.parse(html_url))
    }
}