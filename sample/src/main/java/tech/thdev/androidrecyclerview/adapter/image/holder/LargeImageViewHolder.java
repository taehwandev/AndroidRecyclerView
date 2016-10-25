package tech.thdev.androidrecyclerview.adapter.image.holder;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.ViewGroup;
import android.widget.ImageView;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import butterknife.BindView;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import tech.thdev.androidrecyclerview.MyApplication;
import tech.thdev.androidrecyclerview.R;
import tech.thdev.androidrecyclerview.data.LocalImage;
import tech.thdev.support.widget.adapter.simple.BaseTypedefRecyclerAdapter;
import tech.thdev.support.widget.adapter.simple.holder.BaseViewHolder;

/**
 * Created by Tae-hwan on 18/10/2016.
 */

public class LargeImageViewHolder extends BaseViewHolder<LocalImage> {

    @BindView(R.id.img_large)
    ImageView imageView;

    public LargeImageViewHolder(@Nullable ViewGroup parent, @NotNull BaseTypedefRecyclerAdapter<LocalImage> adapter) {
        super(R.layout.item_large_view, parent, adapter);
    }

    @Override
    public void onViewHolder(LocalImage localImage, int position) {
        Observable.just(localImage)
                .subscribeOn(Schedulers.newThread())
                .map(new Function<LocalImage, Bitmap>() {
                    @Override
                    public Bitmap apply(LocalImage localImage) throws Exception {
                        return BitmapFactory.decodeResource(MyApplication.Companion.getAppContext().getResources(), localImage.getResource());
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Bitmap>() {
                    @Override
                    public void accept(Bitmap bitmap) throws Exception {
                        imageView.setImageBitmap(bitmap);
                    }
                });
    }
}
