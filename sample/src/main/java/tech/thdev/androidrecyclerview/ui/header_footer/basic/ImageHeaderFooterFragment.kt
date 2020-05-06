package tech.thdev.androidrecyclerview.ui.header_footer.basic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import tech.thdev.androidrecyclerview.data.source.image.ImagesRepository
import tech.thdev.androidrecyclerview.databinding.FragmentBasicCustomScrollBinding
import tech.thdev.androidrecyclerview.ui.header_footer.basic.adapter.ImageHeaderFooterSampleAdapter
import tech.thdev.androidrecyclerview.ui.header_footer.basic.presenter.ImageHeaderFooterContract
import tech.thdev.androidrecyclerview.ui.header_footer.basic.presenter.ImageHeaderFooterPresenter
import tech.thdev.base.ui.BasePresenterFragment

/**
 * Created by Tae-hwan on 17/10/2016.
 */
class ImageHeaderFooterFragment :
    BasePresenterFragment<ImageHeaderFooterContract.View, ImageHeaderFooterContract.Presenter>(),
    ImageHeaderFooterContract.View {

    companion object {
        fun getInstance(): ImageHeaderFooterFragment =
            ImageHeaderFooterFragment()
    }

    private val headerFooterAdapter by lazy {
        ImageHeaderFooterSampleAdapter()
    }

    override fun onCreatePresenter() =
        ImageHeaderFooterPresenter(
            headerFooterAdapter,
            headerFooterAdapter,
            ImagesRepository()
        )

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
    }

    private fun initView() {
        binding.root.adapter = headerFooterAdapter

        presenter.addHeaderImageList()
        presenter.addFooterItem()
        presenter.loadImageList()
    }

    override fun loadSuccess() {
        Toast.makeText(context, "Load Success", Toast.LENGTH_SHORT).show()
    }

    override fun loadFail() {
        Toast.makeText(context, "Load Fail", Toast.LENGTH_SHORT).show()
    }
}