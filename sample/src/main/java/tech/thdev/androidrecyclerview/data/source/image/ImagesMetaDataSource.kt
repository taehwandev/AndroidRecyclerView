package tech.thdev.androidrecyclerview.data.source.image

import io.reactivex.rxjava3.core.Flowable
import tech.thdev.androidrecyclerview.data.LocalImage

/**
 * Created by Tae-hwan on 18/10/2016.
 */
interface ImagesMetaDataSource {
    fun getAllImages(): Flowable<List<LocalImage>>
}