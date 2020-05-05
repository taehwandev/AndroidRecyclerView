package tech.thdev.androidrecyclerview.data.source.prefix

import android.content.Context

/**
 * Created by Tae-hwan on 14/11/2016.
 */

object PrefixRepository : PrefixDataSource {

    private val dataSource: PrefixAppDataSource = PrefixAppDataSource()

    override fun getPrefixList(prefix: String, context: Context)
            = dataSource.getPrefixList(prefix, context)
}