package tech.thdev.androidrecyclerview.data.source.image;

import java.util.List;

import io.reactivex.Observable;
import tech.thdev.androidrecyclerview.data.LocalImage;

/**
 * Created by Tae-hwan on 18/10/2016.
 */

public interface ImagesMetaDataSource {

    Observable<List<LocalImage>> getAllImages();
}
