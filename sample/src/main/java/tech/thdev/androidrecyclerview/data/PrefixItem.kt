package tech.thdev.androidrecyclerview.data

import android.content.Context
import android.content.Intent
import tech.thdev.androidrecyclerview.contract.KEY_EXTRA_PATH
import tech.thdev.androidrecyclerview.ui.main.SampleListActivity
import tech.thdev.support.widget.data.BaseItem

/**
 * Created by Tae-hwan on 11/10/2016.
 */

data class PrefixItem(
    val title: String,
    override val viewType: Int
) : BaseItem {

    var intent: Intent? = null

    fun setActivityIntent(pkg: String, componentName: String): PrefixItem {
        intent = Intent()
        intent?.setClassName(pkg, componentName)
        return this
    }

    fun setBrowseIntent(context: Context, path: String): PrefixItem {
        intent = Intent()
        intent?.setClass(context, SampleListActivity::class.java)
        intent?.putExtra(KEY_EXTRA_PATH, path)
        return this
    }
}