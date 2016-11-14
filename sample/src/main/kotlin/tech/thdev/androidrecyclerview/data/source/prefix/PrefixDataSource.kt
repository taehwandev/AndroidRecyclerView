package tech.thdev.androidrecyclerview.data.source.prefix

import android.content.Context
import io.reactivex.Flowable
import tech.thdev.androidrecyclerview.data.PrefixItem

/**
 * Created by Tae-hwan on 14/11/2016.
 */

interface PrefixDataSource {

    fun getPrefixList(prefix: String?, context: Context): Flowable<List<PrefixItem>>
}