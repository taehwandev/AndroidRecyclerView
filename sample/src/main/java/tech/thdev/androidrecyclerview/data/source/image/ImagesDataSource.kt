package tech.thdev.androidrecyclerview.data.source.image

import io.reactivex.rxjava3.core.Flowable
import tech.thdev.androidrecyclerview.data.Image

/**
 * Created by Tae-hwan on 17/10/2016.
 */

interface ImagesDataSource {

    fun getAllImages(): Flowable<List<Image>>
}