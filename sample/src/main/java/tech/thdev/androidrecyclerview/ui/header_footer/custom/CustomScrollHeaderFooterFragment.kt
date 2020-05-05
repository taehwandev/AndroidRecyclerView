package tech.thdev.androidrecyclerview.ui.header_footer.custom

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import tech.thdev.androidrecyclerview.R
import tech.thdev.androidrecyclerview.ui.header_footer.custom.adapter.CustomScrollHeaderFooterAdapter
import tech.thdev.androidrecyclerview.data.source.image.ImagesMetaLocalRepository
import tech.thdev.androidrecyclerview.databinding.FragmentCustomScrollHeaderFooterBinding
import tech.thdev.androidrecyclerview.ui.scroll.anim.OnRecyclerScrollListener
import tech.thdev.androidrecyclerview.ui.header_footer.custom.presenter.CustomScrollHeaderFooterContract
import tech.thdev.androidrecyclerview.ui.header_footer.custom.presenter.CustomScrollHeaderFooterPresenter
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

    @BindView(R.id.recycler_view)
    var mRecyclerView: RecyclerView? = null
    private var rlBottomLayout: RelativeLayout? = null
    private var manager: GridLayoutManager? = null

    private val viewHeader: View by lazy {
        requireActivity().findViewById(R.id.rl_head)
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

    val layout: Int
        get() = R.layout.fragment_custom_scroll_header_footer

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

    }

    private fun initView() {
        viewHeader.measure(
            View.MeasureSpec.UNSPECIFIED,
            View.MeasureSpec.UNSPECIFIED
        )

    }

    fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rlBottomLayout = getActivity().findViewById(R.id.rl_bottom_layout)
        val adapter =
            CustomScrollHeaderFooterAdapter(
                getContext()
            )
        getPresenter().setAdapterView(adapter)
        getPresenter().setAdapterModel(adapter)
        getPresenter().setMetaLocalRepository(ImagesMetaLocalRepository.instance)
        manager = GridLayoutManager(getContext(), 2)
        manager.setSpanSizeLookup(object : SpanSizeLookup() {
            fun getSpanSize(position: Int): Int {
                return if (adapter.hasHeaderItems(position) || adapter.hasFooterItem(position)) manager.getSpanCount() else 1
            }
        })
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.setLayoutManager(manager)
        mRecyclerView.setAdapter(adapter)
        mRecyclerView.addOnScrollListener(onCustomScrollListener)
        rlHead!!.measure(
            View.MeasureSpec.UNSPECIFIED,
            View.MeasureSpec.UNSPECIFIED
        )
        onCustomScrollListener.addView(rlHead, -rlHead!!.measuredHeight)
        rlBottomLayout!!.measure(
            View.MeasureSpec.UNSPECIFIED,
            View.MeasureSpec.UNSPECIFIED
        )
        onCustomScrollListener.addView(rlBottomLayout, rlBottomLayout!!.measuredHeight)
        getPresenter().loadHeader()
        getPresenter().loadFooter()
        getPresenter().loadImage()
    }

    override fun showProgress() {}
    override fun hideProgress() {}
    override fun loadFail() {}
    fun onDestroy() {
        super.onDestroy()
        if (mRecyclerView != null) {
            onCustomScrollListener.destroy()
            mRecyclerView.removeOnScrollListener(onCustomScrollListener)
        }
    }

    private val onCustomScrollListener: OnRecyclerScrollListener =
        object : OnRecyclerScrollListener() {
            fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
            }

            fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                Log.d(
                    "TAG",
                    "computeHorizontalScrollOffset " + recyclerView.computeVerticalScrollOffset()
                )
                Log.e("TAG", "-------------------")
            }
        }
}