package tech.thdev.androidrecyclerview.data

import androidx.annotation.DrawableRes
import tech.thdev.support.widget.data.BaseItem

/**
 * Created by Tae-hwan on 17/10/2016.
 */

data class Image(
    @DrawableRes val img: Int,
    val title: String,
    val message: String,
    override val viewType: Int
) : BaseItem