package tech.thdev.androidrecyclerview.ui.custom_scroll.basic

import android.os.Bundle
import tech.thdev.androidrecyclerview.R
import tech.thdev.androidrecyclerview.databinding.ActivityBasicCustomScrollBinding
import tech.thdev.base.ui.BaseActivity
import tech.thdev.base.util.replaceContentFragment

/**
 * Created by Tae-hwan on 18/10/2016.
 */
class BasicCustomScrollActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityBasicCustomScrollBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceContentFragment(R.id.frame_layout, BasicCustomScrollFragment.newInstance())
    }
}