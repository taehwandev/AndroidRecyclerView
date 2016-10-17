package tech.thdev.androidrecyclerview.data.source.image

import io.reactivex.Observable
import tech.thdev.androidrecyclerview.data.Image

/**
 * Created by Tae-hwan on 17/10/2016.
 */

interface ImagesDataSource {

    fun getAllImages(): Observable<List<Image>>
}