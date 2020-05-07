package tech.thdev.androidrecyclerview.ui.local_image

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import tech.thdev.androidrecyclerview.data.source.image.ImagesRepository
import tech.thdev.androidrecyclerview.databinding.FragmentCustomScrollAnimationBinding
import tech.thdev.androidrecyclerview.ui.local_image.adapter.LocalImageAdapter
import tech.thdev.androidrecyclerview.ui.local_image.presenter.LocalImageContract
import tech.thdev.androidrecyclerview.ui.local_image.presenter.LocalImagePresenter
import tech.thdev.base.ui.BasePresenterFragment

/**
 * Created by Tae-hwan on 17/10/2016.
 */
class LocalImageFragment :
    BasePresenterFragment<LocalImageContract.View, LocalImageContract.Presenter>(),
    LocalImageContract.View {

    companion object {
        fun getInstance() =
            LocalImageFragment()
    }

    private val imageAdapter by lazy {
        LocalImageAdapter()
    }

    override fun onCreatePresenter() =
        LocalImagePresenter(
            imageAdapter,
            imageAdapter,
            ImagesRepository()
        )

    private lateinit var binding: FragmentCustomScrollAnimationBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCustomScrollAnimationBinding.inflate(layoutInflater)
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