package tech.thdev.androidrecyclerview.ui.basic

import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import tech.thdev.androidrecyclerview.databinding.ActivityBasicRecyclerViewBinding
import tech.thdev.androidrecyclerview.ui.basic.adapter.BasicRecyclerViewAdapter
import tech.thdev.androidrecyclerview.ui.basic.presenter.BasicRecyclerViewContract
import tech.thdev.androidrecyclerview.ui.basic.presenter.BasicRecyclerViewPresenter
import tech.thdev.base.ui.BasePresenterActivity

/**
 * Created by Tae-hwan on 11/10/2016.
 */
class BasicRecyclerViewActivity :
    BasePresenterActivity<BasicRecyclerViewContract.View, BasicRecyclerViewContract.Presenter>(),
    BasicRecyclerViewContract.View {

    private val basicAdapter: BasicRecyclerViewAdapter by lazy {
        BasicRecyclerViewAdapter()
    }

    override fun onCreatePresenter(): BasicRecyclerViewContract.Presenter {
        return BasicRecyclerViewPresenter(
            basicAdapter,
            basicAdapter
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityBasicRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.recyclerView.run {
            layoutManager = GridLayoutManager(this@BasicRecyclerViewActivity, 2)
            adapter = basicAdapter
        }
        presenter.loadList(500)
    }

    override fun showToast(item: String) {
        Toast.makeText(this, item, Toast.LENGTH_SHORT).show()
    }
}