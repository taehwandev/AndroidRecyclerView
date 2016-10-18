package tech.thdev.androidrecyclerview.data.source.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.drew.metadata.exif.ExifSubIFDDescriptor;
import com.drew.metadata.exif.ExifSubIFDDirectory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import tech.thdev.androidrecyclerview.MyApplication;
import tech.thdev.androidrecyclerview.data.LocalImage;

/**
 * Created by Tae-hwan on 18/10/2016.
 */

class ImagesMetaLocalDataSource implements ImagesMetaDataSource {

    private List<LocalImage> imageList = new ArrayList<>();

    @Override
    public Observable<List<LocalImage>> getAllImages() {
        if (imageList.size() < 14) {
            Observable.range(1, 14)
                    .map(new Function<Integer, LocalImage>() {
                        @Override
                        public LocalImage apply(Integer integer) throws Exception {
                            String name = String.format(Locale.ENGLISH, "sample_%02d", integer);
                            int resource = MyApplication.Companion.getAppContext()
                                    .getResources()
                                    .getIdentifier(name, "drawable", MyApplication.Companion.getAppContext().getPackageName());

                            return new LocalImage(resource, "name", "2016-10-18", 0);
                        }
                    })
                    .subscribe(new Consumer<LocalImage>() {

                        @Override
                        public void accept(LocalImage localImage) throws Exception {
                            imageList.add(localImage);
                        }
                    });
        }
        return Observable.fromArray(imageList);
    }
}
