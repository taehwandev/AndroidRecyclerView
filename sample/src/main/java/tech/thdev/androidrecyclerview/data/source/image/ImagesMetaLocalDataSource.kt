package tech.thdev.androidrecyclerview.data.source.image

import io.reactivex.rxjava3.core.Flowable
import tech.thdev.androidrecyclerview.MyApplication.Companion.appContext
import tech.thdev.androidrecyclerview.data.LocalImage
import java.util.*

/**
 * Created by Tae-hwan on 18/10/2016.
 */
internal class ImagesMetaLocalDataSource : ImagesMetaDataSource {

    private val imageList = mutableListOf<LocalImage>()

    override fun getAllImages(): Flowable<List<LocalImage>> {
        if (imageList.size < 14) {
            Flowable.range(1, 14)
                .map { integer ->
                    val name =
                        String.format(Locale.ENGLISH, "sample_%02d", integer)
                    val resource = appContext
                        .resources
                        .getIdentifier(
                            name,
                            "drawable",
                            appContext.packageName
                        )
                    LocalImage(resource, "name", "2016-10-18", 0)
                }
                .subscribe { localImage -> imageList.add(localImage) }
        }
        return Flowable.fromArray(imageList)
    }
}