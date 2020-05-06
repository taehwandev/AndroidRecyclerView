package tech.thdev.androidrecyclerview.ui.design.local_image

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import tech.thdev.androidrecyclerview.data.source.image.ImagesRepository
import tech.thdev.androidrecyclerview.databinding.FragmentBasicCustomScrollBinding
import tech.thdev.androidrecyclerview.ui.design.local_image.adapter.ImageListAdapter
import tech.thdev.androidrecyclerview.ui.design.local_image.presenter.ImageListContract
import tech.thdev.androidrecyclerview.ui.design.local_image.presenter.ImageListPresenter
import tech.thdev.base.ui.BasePresenterFragment

/**
 * Created by Tae-hwan on 17/10/2016.
 */
class LocalImageFragment :
    BasePresenterFragment<ImageListContract.View, ImageListContract.Presenter>(),
    ImageListContract.View {

    companion object {
        fun getInstance() =
            LocalImageFragment()
    }

    private val imageAdapter by lazy {
        ImageListAdapter()
    }

    override fun onCreatePresenter() =
        ImageListPresenter(
            imageAdapter,
            imageAdapter,
            ImagesRepository()
        )

    private lateinit var binding: FragmentBasicCustomScrollBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBasicCustomScrollBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.root.adapter = imageAdapter

        presenter.loadImageList()
    }

    override fun loadSuccess() {
        Toast.makeText(context, "Load Success", Toast.LENGTH_SHORT).show()
    }

    override fun loadFail() {
        Toast.makeText(context, "Load Fail", Toast.LENGTH_SHORT).show()
    }
}