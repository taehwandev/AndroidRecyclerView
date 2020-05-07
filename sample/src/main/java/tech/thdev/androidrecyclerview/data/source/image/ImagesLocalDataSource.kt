package tech.thdev.androidrecyclerview.data.source.image

import io.reactivex.rxjava3.core.Flowable
import tech.thdev.androidrecyclerview.MyApplication
import tech.thdev.androidrecyclerview.data.Image
import java.util.*

/**
 * Created by Tae-hwan on 17/10/2016.
 */

class ImagesLocalDataSource : ImagesDataSource {

    private val imageList = ArrayList<Image>()

    override fun getAllImages(): Flowable<List<Image>> {
        if (imageList.size < 14) {
            Flowable.range(1, 14)
                .map {
                    val name = String.format("sample_%02d", it)
                    val resource = MyApplication.appContext.resources.getIdentifier(
                        name,
                        "drawable",
                        MyApplication.appContext.packageName
                    )
                    Image(resource, name, "Message $name", 0)
                }
                .subscribe {
                    imageList.add(it)
                }
        }

        return Flowable.fromArray(imageList)
    }
}