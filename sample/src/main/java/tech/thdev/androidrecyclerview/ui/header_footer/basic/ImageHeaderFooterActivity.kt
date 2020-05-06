package tech.thdev.androidrecyclerview.ui.header_footer.basic

import android.os.Bundle
import tech.thdev.androidrecyclerview.R
import tech.thdev.androidrecyclerview.databinding.ActivityFragmentViewBinding
import tech.thdev.base.ui.BaseActivity
import tech.thdev.base.util.replaceContentFragment

/**
 * Created by Tae-hwan on 17/10/2016.
 */

class ImageHeaderFooterActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFragmentViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.collapsingToolbar.title = getString(R.string.label_activity_header_footer_sample)

        replaceContentFragment(R.id.frame_layout, ImageHeaderFooterFragment.getInstance())
    }
}