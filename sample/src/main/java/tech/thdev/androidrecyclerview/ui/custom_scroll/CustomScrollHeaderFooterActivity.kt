package tech.thdev.androidrecyclerview.ui.custom_scroll

import android.os.Bundle
import tech.thdev.androidrecyclerview.R
import tech.thdev.base.ui.BaseActivity
import tech.thdev.base.util.replaceContentFragment

/**
 * Created by Tae-hwan on 01/11/2016.
 */
class CustomScrollHeaderFooterActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_scroll_header_footer)

        replaceContentFragment(R.id.frame_layout,
            CustomScrollHeaderFooterFragment.newInstance()
        )
    }
}