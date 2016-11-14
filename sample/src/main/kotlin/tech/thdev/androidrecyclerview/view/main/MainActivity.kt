package tech.thdev.androidrecyclerview.view.main

import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_recycler_view.*
import tech.thdev.androidrecyclerview.R
import tech.thdev.androidrecyclerview.contract.Contract
import tech.thdev.androidrecyclerview.data.source.prefix.PrefixRepository
import tech.thdev.androidrecyclerview.view.main.adapter.MainListAdapter
import tech.thdev.androidrecyclerview.view.main.presenter.MainContract
import tech.thdev.androidrecyclerview.view.main.presenter.MainPresenter
import tech.thdev.base.view.BasePresenterActivity

/**
 * Have a list of samples.
 */
class MainActivity : BasePresenterActivity<MainContract.View, MainContract.Presenter>(), MainContract.View {

    override fun onCreatePresenter() = MainPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        setSupportActionBar(toolbar)

        val prefix = intent.getStringExtra(Contract.KEY_EXTRA_PATH)

        val adapter = MainListAdapter(this)

        // set model
        presenter?.prefixRepository = PrefixRepository
        // set adapter model
        presenter?.adapterContractModel = adapter
        // set adapter view
        presenter?.adapterContractView = adapter

        recycler_view.adapter = adapter

        presenter?.getSampleList(prefix, this)
    }

    override fun changeActivity(intent: Intent) {
        startActivity(intent)
    }
}
