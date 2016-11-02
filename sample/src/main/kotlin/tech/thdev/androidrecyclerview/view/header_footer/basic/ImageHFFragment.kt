package tech.thdev.androidrecyclerview.view.header_footer.basic

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import tech.thdev.androidrecyclerview.R
import tech.thdev.androidrecyclerview.adapter.header_footer.ImageHeaderFooterSampleAdapter
import tech.thdev.androidrecyclerview.data.source.image.ImagesRepository
import tech.thdev.androidrecyclerview.view.header_footer.basic.presenter.ImageHFContract
import tech.thdev.androidrecyclerview.view.header_footer.basic.presenter.ImageHFPresenter
import tech.thdev.base.view.BasePresenterFragment

/**
 * Created by Tae-hwan on 17/10/2016.
 */

class ImageHFFragment :
        BasePresenterFragment<ImageHFContract.View, ImageHFContract.Presenter>(),
        ImageHFContract.View {

    private val recyclerView by lazy {
        view?.findViewById(R.id.recycler_view) as RecyclerView
    }

    override fun onCreatePresenter() = ImageHFPresenter()

    companion object {
        fun getInstance() = ImageHFFragment()
    }

    override fun getLayout() = R.layout.fragment_basic_custom_scroll

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageListAdapter = ImageHeaderFooterSampleAdapter(context)

        presenter?.listContractModel = imageListAdapter
        presenter?.listContractView = imageListAdapter

        presenter?.imageRepository = ImagesRepository()

        recyclerView.adapter = imageListAdapter

        presenter?.addHeaderImageList()
        presenter?.addFooterItem()
        presenter?.loadImageList()
    }

    override fun loadSuccess() {
        Toast.makeText(context, "Load Success", Toast.LENGTH_SHORT).show()
    }

    override fun loadFail() {
        Toast.makeText(context, "Load Fail", Toast.LENGTH_SHORT).show()
    }
}