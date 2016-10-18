package tech.thdev.androidrecyclerview.view.design.image.presenter;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import tech.thdev.androidrecyclerview.adapter.model.AdapterContract;
import tech.thdev.androidrecyclerview.data.LocalImage;
import tech.thdev.androidrecyclerview.data.source.image.ImagesMetaLocalRepository;
import tech.thdev.base.presenter.AbstractPresenter;

/**
 * Created by Tae-hwan on 18/10/2016.
 */

public class CustomScrollImagePresenter extends AbstractPresenter<CustomScrollImageContract.View> implements CustomScrollImageContract.Presenter {

    private AdapterContract.View adapterView;
    private AdapterContract.Model<LocalImage> adapterModel;

    private ImagesMetaLocalRepository metaLocalRepository;

    @Override
    public void setAdapterView(AdapterContract.View adapterView) {
        this.adapterView = adapterView;
    }

    @Override
    public void setAdapterModel(AdapterContract.Model<LocalImage> adapterModel) {
        this.adapterModel = adapterModel;
    }

    @Override
    public void setMetaLocalRepository(ImagesMetaLocalRepository metaLocalRepository) {
        this.metaLocalRepository = metaLocalRepository;
    }

    @Override
    public void updateImage() {
        metaLocalRepository.getAllImages()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Consumer<Disposable>() {

                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        getView().showProgress();
                    }
                })
                .doOnComplete(new Action() {

                    @Override
                    public void run() throws Exception {
                        if (adapterView != null) {
                            adapterView.reload();
                        }

                        getView().hideProgress();
                    }
                })
                .subscribe(new Consumer<List<LocalImage>>() {

                    @Override
                    public void accept(List<LocalImage> localImages) throws Exception {
                        if (adapterModel != null) {
                            adapterModel.addItems(localImages);
                        }
                    }
                }, new Consumer<Throwable>() {

                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getView().loadFail();
                    }
                });
    }
}
