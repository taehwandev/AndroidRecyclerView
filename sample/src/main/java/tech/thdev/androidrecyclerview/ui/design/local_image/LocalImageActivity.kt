package tech.thdev.androidrecyclerview.ui.design.local_image

import android.os.Bundle
import tech.thdev.androidrecyclerview.R
import tech.thdev.androidrecyclerview.databinding.ActivityFragmentViewBinding
import tech.thdev.base.ui.BaseActivity
import tech.thdev.base.util.replaceContentFragment

/**
 * Created by Tae-hwan on 17/10/2016.
 */

class LocalImageActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFragmentViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.collapsingToolbar.title = getString(R.string.label_activity_image)

        replaceContentFragment(R.id.frame_layout, LocalImageFragment.getInstance())
    }
}