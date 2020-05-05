package tech.thdev.androidrecyclerview.ui.basic.mvp

import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import tech.thdev.androidrecyclerview.databinding.ActivityBasicBinding
import tech.thdev.androidrecyclerview.ui.basic.mvp.adapter.BasicMVPAdapter
import tech.thdev.androidrecyclerview.ui.basic.mvp.presenter.BasicMVPContract
import tech.thdev.androidrecyclerview.ui.basic.mvp.presenter.BasicMVPPresenter
import tech.thdev.base.ui.BasePresenterActivity

/**
 * Created by Tae-hwan on 11/10/2016.
 */
class BasicMVPActivity :
    BasePresenterActivity<BasicMVPContract.View, BasicMVPContract.Presenter>(),
    BasicMVPContract.View {
    //    @BindView(R.id.recycler_view)
    //    RecyclerView recyclerView;

    private val basicAdapter: BasicMVPAdapter by lazy {
        BasicMVPAdapter()
    }

    override fun onCreatePresenter(): BasicMVPContract.Presenter {
        return BasicMVPPresenter(
            basicAdapter,
            basicAdapter
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityBasicBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.run {
            layoutManager = GridLayoutManager(this@BasicMVPActivity, 2)
            adapter = basicAdapter
        }
        presenter.loadList(500)
    }

    override fun showToast(item: String) {
        Toast.makeText(this, item, Toast.LENGTH_SHORT).show()
    }
}