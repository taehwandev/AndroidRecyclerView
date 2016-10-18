package tech.thdev.androidrecyclerview.data.source.image;

import java.util.List;

import io.reactivex.Observable;
import tech.thdev.androidrecyclerview.data.LocalImage;

/**
 * Created by Tae-hwan on 18/10/2016.
 */

public class ImagesMetaLocalRepository implements ImagesMetaDataSource {

    private ImagesMetaLocalDataSource dataSource;

    private ImagesMetaLocalRepository() {
        dataSource = new ImagesMetaLocalDataSource();
    }

    private static ImagesMetaLocalRepository repository;
    public static ImagesMetaLocalRepository getInstance() {
        if (repository == null) {
            repository = new ImagesMetaLocalRepository();
        }
        return repository;
    }

    @Override
    public Observable<List<LocalImage>> getAllImages() {
        return dataSource.getAllImages();
    }
}
