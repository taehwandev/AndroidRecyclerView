package tech.thdev.androidrecyclerview.ui.main

import android.content.Intent
import android.os.Bundle
import tech.thdev.androidrecyclerview.R
import tech.thdev.androidrecyclerview.contract.KEY_EXTRA_PATH
import tech.thdev.androidrecyclerview.data.source.prefix.PrefixRepository
import tech.thdev.androidrecyclerview.databinding.ActivityMainBinding
import tech.thdev.androidrecyclerview.ui.main.adapter.MainAdapter
import tech.thdev.androidrecyclerview.ui.main.presenter.MainContract
import tech.thdev.androidrecyclerview.ui.main.presenter.MainPresenter
import tech.thdev.base.ui.BasePresenterActivity

/**
 * Created by Tae-hwan on 14/11/2016.
 *
 * Have a list of samples.
 */
class MainActivity :
    BasePresenterActivity<MainContract.View, MainContract.Presenter>(),
    MainContract.View {

    private val adapter by lazy {
        MainAdapter()
    }

    override fun onCreatePresenter() = MainPresenter(
        adapter,
        adapter,
        PrefixRepository
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val prefix = intent.getStringExtra(KEY_EXTRA_PATH)
        title = prefix ?: getString(R.string.app_name)

        binding.recyclerView.adapter = adapter

        presenter.getSampleList(prefix, this)
    }

    override fun changeActivity(intent: Intent) {
        startActivity(intent)
    }
}