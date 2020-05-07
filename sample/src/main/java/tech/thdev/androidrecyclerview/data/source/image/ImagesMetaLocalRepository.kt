package tech.thdev.androidrecyclerview.data.source.image

import io.reactivex.rxjava3.core.Flowable
import tech.thdev.androidrecyclerview.data.LocalImage

/**
 * Created by Tae-hwan on 18/10/2016.
 */
class ImagesMetaLocalRepository private constructor() : ImagesMetaDataSource {

    companion object {
        private var repository: ImagesMetaLocalRepository? = null

        fun newInstance(): ImagesMetaLocalRepository =
            repository ?: ImagesMetaLocalRepository().also { repository = it }
    }

    private val dataSource: ImagesMetaLocalDataSource = ImagesMetaLocalDataSource()

    override fun getAllImages(): Flowable<List<LocalImage>> {
        return dataSource.getAllImages()
    }
}