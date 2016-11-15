package tech.thdev.androidrecyclerview.view.basic.not_mvp

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_basic_custom_scroll.*
import tech.thdev.androidrecyclerview.R
import tech.thdev.base.view.BaseActivity

/**
 * Created by Tae-hwan on 14/11/2016.
 */

class BasicKotlinActivity : BaseActivity() {

    private val recyclerView by lazy {
        findViewById(R.id.recycler_view) as RecyclerView
    }

    private val fab by lazy {
        findViewById(R.id.fab) as FloatingActionButton
    }

    private val mAdapter by lazy {
        BasicKotlinAdapter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic)

        // setItems
        setItems()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = mAdapter

        mAdapter.setOnItemClickListener { adapter, i ->
            Snackbar.make(fab, "${mAdapter.getItem(i)}", Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun setItems() {
        for (index in 1..100) {
            mAdapter.addItem("Kotlin simple item $index")
        }
    }
}