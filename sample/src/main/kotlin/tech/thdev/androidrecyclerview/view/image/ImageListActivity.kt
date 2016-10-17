package tech.thdev.androidrecyclerview.view.image

import android.os.Bundle
import tech.thdev.androidrecyclerview.R
import tech.thdev.base.util.replaceContentFragment
import tech.thdev.base.view.BaseActivity

/**
 * Created by Tae-hwan on 17/10/2016.
 */

class ImageListActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_view)

        replaceContentFragment(R.id.frame_layout, ImageListFragment.getInstance())
    }
}