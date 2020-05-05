package tech.thdev.androidrecyclerview.data

import androidx.annotation.DrawableRes
import tech.thdev.support.widget.data.BaseItem

/**
 * Created by Tae-hwan on 18/10/2016.
 */
class LocalImage(
    @field:DrawableRes val resource: Int,
    val title: String,
    val date: String,
    override val viewType: Int
) : BaseItem 