package tech.thdev.androidrecyclerview.view.design.local_image

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import tech.thdev.androidrecyclerview.R
import tech.thdev.androidrecyclerview.adapter.ImageListAdapter
import tech.thdev.androidrecyclerview.data.source.image.ImagesRepository
import tech.thdev.androidrecyclerview.view.design.local_image.presenter.ImageListContract
import tech.thdev.androidrecyclerview.view.design.local_image.presenter.ImageListPresenter
import tech.thdev.base.view.BasePresenterFragment

/**
 * Created by Tae-hwan on 17/10/2016.
 */

class LocalImageFragment :
        BasePresenterFragment<ImageListContract.View, ImageListContract.Presenter>(),
        ImageListContract.View {

    private val recyclerView by lazy {
        view?.findViewById(R.id.recycler_view) as RecyclerView
    }

    override fun onCreatePresenter() = ImageListPresenter()

    companion object {
        fun getInstance() = LocalImageFragment()
    }

    override fun getLayout() = R.layout.fragment_basic_custom_scroll

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageListAdapter = ImageListAdapter(context)

        presenter?.listContractModel = imageListAdapter
        presenter?.listContractView = imageListAdapter

        presenter?.imageRepository = ImagesRepository()

        recyclerView.adapter = imageListAdapter

        presenter?.loadImageList()
    }

    override fun loadSuccess() {
        Toast.makeText(context, "Load Success", Toast.LENGTH_SHORT).show()
    }

    override fun loadFail() {
        Toast.makeText(context, "Load Fail", Toast.LENGTH_SHORT).show()
    }
}