package tech.thdev.androidrecyclerview.data.source.image

/**
 * Created by Tae-hwan on 17/10/2016.
 */

class ImagesRepository : ImagesDataSource {

    private val imageLocalDataSource: ImagesLocalDataSource

    init {
        imageLocalDataSource = ImagesLocalDataSource()
    }

    override fun getAllImages() = imageLocalDataSource.getAllImages()
}