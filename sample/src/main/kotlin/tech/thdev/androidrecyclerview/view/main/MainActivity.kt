package tech.thdev.androidrecyclerview.view.main

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import tech.thdev.androidrecyclerview.R
import tech.thdev.androidrecyclerview.adapter.MainListAdapter
import tech.thdev.androidrecyclerview.contract.Contract
import tech.thdev.androidrecyclerview.view.main.presenter.MainContract
import tech.thdev.androidrecyclerview.view.main.presenter.MainPresenter
import tech.thdev.base.view.BasePresenterActivity

class MainActivity : BasePresenterActivity<MainContract.View, MainContract.Presenter>(), MainContract.View {

    private val recyclerView by lazy {
        findViewById(R.id.recycler_view) as RecyclerView
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val prefix = intent.getStringExtra(Contract.KEY_EXTRA_PATH)

        val adapter = MainListAdapter(this)
        adapter.setOnClickListener { view, i -> presenter?.onListItemClick(i) }
        presenter?.adapterContractModel = adapter
        presenter?.adapterContractView = adapter

        recyclerView.adapter = adapter

        presenter?.getSampleList(prefix, this)
    }

    override fun changeActivity(intent: Intent?) {
        intent?.let { startActivity(it) }
    }

    override fun onCreatePresenter() = MainPresenter()
}
