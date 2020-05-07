package tech.thdev.androidrecyclerview.ui.header_footer

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import tech.thdev.androidrecyclerview.R
import tech.thdev.androidrecyclerview.data.source.image.ImagesMetaLocalRepository
import tech.thdev.androidrecyclerview.databinding.FragmentCustomScrollHeaderFooterBinding
import tech.thdev.androidrecyclerview.ui.header_footer.adapter.CustomScrollHeaderFooterAdapter
import tech.thdev.androidrecyclerview.ui.header_footer.presenter.CustomScrollHeaderFooterContract
import tech.thdev.androidrecyclerview.ui.header_footer.presenter.CustomScrollHeaderFooterPresenter
import tech.thdev.androidrecyclerview.ui.scroll.anim.OnRecyclerScrollListener
import tech.thdev.base.ui.BasePresenterFragment

/**
 * Created by Tae-hwan on 18/10/2016.
 */
class CustomScrollHeaderFooterFragment :
    BasePresenterFragment<CustomScrollHeaderFooterContract.View, CustomScrollHeaderFooterContract.Presenter>(),
    CustomScrollHeaderFooterContract.View {

    companion object {
        fun newInstance(): CustomScrollHeaderFooterFragment =
            CustomScrollHeaderFooterFragment()
    }

    private val viewHeader: View by lazy {
        requireActivity().findViewById<View>(R.id.rl_head)
    }
    private val viewBottom: View by lazy {
        requireActivity().findViewById<View>(R.id.rl_bottom_layout)
    }

    private val headerFooterAdapter: CustomScrollHeaderFooterAdapter by lazy {
        CustomScrollHeaderFooterAdapter()
    }

    override fun onCreatePresenter(): CustomScrollHeaderFooterContract.Presenter {
        return CustomScrollHeaderFooterPresenter(
            adapterView = headerFooterAdapter,
            adapterModel = headerFooterAdapter,
            metaLocalRepository = ImagesMetaLocalRepository.newInstance()
        )
    }

    private lateinit var binding: FragmentCustomScrollHeaderFooterBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCustomScrollHeaderFooterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        presenter.loadHeader()
        presenter.loadFooter()
        presenter.loadImage()
    }

    private fun initView() {
        binding.root.run {
            layoutManager = GridLayoutManager(requireContext(), 2).apply {
                spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                    override fun getSpanSize(position: Int): Int {
                        return if (headerFooterAdapter.hasHeaderItems(position)
                            || headerFooterAdapter.hasFooterItem(position)
                        ) spanCount
                        else 1
                    }
                }
            }
            setHasFixedSize(true)
            adapter = headerFooterAdapter
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

        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
        }

        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            Log.d(
                "TAG",
                "computeHorizontalScrollOffset " + recyclerView.computeVerticalScrollOffset()
            )
            Log.e("TAG", "-------------------")
        }
    }
}