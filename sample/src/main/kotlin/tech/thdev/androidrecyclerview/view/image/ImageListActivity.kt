package tech.thdev.androidrecyclerview.view.image

import android.os.Bundle
import android.support.design.widget.CollapsingToolbarLayout
import tech.thdev.androidrecyclerview.R
import tech.thdev.base.util.replaceContentFragment
import tech.thdev.base.view.BaseActivity

/**
 * Created by Tae-hwan on 17/10/2016.
 */

class ImageListActivity : BaseActivity() {

    private val collapsingToolbar by lazy {
        findViewById(R.id.collapsing_toolbar) as CollapsingToolbarLayout
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_view)

        collapsingToolbar.title = getString(R.string.label_activity_image)

        replaceContentFragment(R.id.frame_layout, ImageListFragment.getInstance())
    }
}