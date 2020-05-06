package tech.thdev.androidrecyclerview.ui.custom_scroll.basic

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tech.thdev.androidrecyclerview.R
import tech.thdev.androidrecyclerview.data.source.image.ImagesMetaLocalRepository
import tech.thdev.androidrecyclerview.databinding.FragmentBasicCustomScrollBinding
import tech.thdev.androidrecyclerview.ui.custom_scroll.basic.adapter.CustomScrollAdapterSimpleDefinition
import tech.thdev.androidrecyclerview.ui.custom_scroll.basic.presenter.BasicCustomScrollContract
import tech.thdev.androidrecyclerview.ui.custom_scroll.basic.presenter.BasicCustomScrollPresenter
import tech.thdev.androidrecyclerview.ui.scroll.anim.OnRecyclerScrollListener
import tech.thdev.base.ui.BasePresenterFragment

/**
 * Created by Tae-hwan on 18/10/2016.
 */
class BasicCustomScrollFragment :
    BasePresenterFragment<BasicCustomScrollContract.View, BasicCustomScrollContract.Presenter>(),
    BasicCustomScrollContract.View {

    companion object {
        fun newInstance(): BasicCustomScrollFragment =
            BasicCustomScrollFragment()
    }

    private val customAdapter: CustomScrollAdapterSimpleDefinition by lazy {
        CustomScrollAdapterSimpleDefinition()
    }

    override fun onCreatePresenter(): BasicCustomScrollContract.Presenter =
        BasicCustomScrollPresenter(
            customAdapter,
            customAdapter,
            ImagesMetaLocalRepository.newInstance()
        )

    private val viewHeader: View by lazy {
        requireActivity().findViewById<View>(R.id.rl_head)
    }
    private val viewBottom: View by lazy {
        requireActivity().findViewById<View>(R.id.rl_bottom_layout)
    }

    private lateinit var binding: FragmentBasicCustomScrollBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBasicCustomScrollBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        presenter.updateImage()
    }

    private fun initView() {
        binding.root.run {
            adapter = customAdapter
            addOnScrollListener(onCustomScrollListener)
        }

        viewHeader.measure(
            View.MeasureSpec.UNSPECIFIED,
            View.MeasureSpec.UNSPECIFIED
        )
        onCustomScrollListener.addView(viewHeader, -viewHeader.measuredHeight)
        viewBottom.measure(
            View.MeasureSpec.UNSPECIFIED,
            View.MeasureSpec.UNSPECIFIED
        )
        onCustomScrollListener.addView(viewBottom, viewBottom.measuredHeight)
    }

    override fun showProgress() {}
    override fun hideProgress() {}
    override fun loadFail() {}

    override fun onDestroy() {
        super.onDestroy()
        onCustomScrollListener.destroy()
        binding.root.removeOnScrollListener(onCustomScrollListener)
    }

    private val onCustomScrollListener = object : OnRecyclerScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)

            Log.d(
                "TAG",
                "computeHorizontalScrollOffset " + recyclerView.computeVerticalScrollOffset()
            )
            Log.e("TAG", "-------------------")
        }

        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
        }
    }
}