package tech.thdev.androidrecyclerview.view.main

import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import tech.thdev.androidrecyclerview.R
import tech.thdev.androidrecyclerview.contract.Contract
import tech.thdev.androidrecyclerview.data.source.prefix.PrefixRepository
import tech.thdev.androidrecyclerview.view.main.adapter.SampleListAdapter
import tech.thdev.androidrecyclerview.view.main.presenter.SampleListContract
import tech.thdev.androidrecyclerview.view.main.presenter.SampleListPresenter
import tech.thdev.base.view.BasePresenterActivity

/**
 * Created by Tae-hwan on 14/11/2016.
 *
 * Have a list of samples.
 */
class SampleListActivity : BasePresenterActivity<SampleListContract.View, SampleListContract.Presenter>(), SampleListContract.View {

    override fun onCreatePresenter() = SampleListPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        val prefix = intent.getStringExtra(Contract.KEY_EXTRA_PATH)

        title = prefix

        val adapter = SampleListAdapter(this)

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