package tech.thdev.androidrecyclerview

import android.os.Bundle
import tech.thdev.base.view.BaseActivity

/**
 * Created by Tae-hwan on 10/10/2016.
 */

class KtMainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
    }
}