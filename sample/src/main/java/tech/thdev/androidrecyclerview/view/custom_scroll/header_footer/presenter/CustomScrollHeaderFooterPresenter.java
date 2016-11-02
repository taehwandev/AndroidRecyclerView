package tech.thdev.androidrecyclerview.view.custom_scroll.header_footer.presenter;

import java.util.List;
import java.util.Objects;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import tech.thdev.androidrecyclerview.R;
import tech.thdev.androidrecyclerview.adapter.model.AdapterContract;
import tech.thdev.androidrecyclerview.adapter.model.AdapterHeaderFooterContract;
import tech.thdev.androidrecyclerview.data.LocalImage;
import tech.thdev.androidrecyclerview.data.source.image.ImagesMetaLocalRepository;
import tech.thdev.androidrecyclerview.view.custom_scroll.basic.presenter.BasicCustomScrollContract;
import tech.thdev.base.presenter.AbstractPresenter;

/**
 * Created by Tae-hwan on 18/10/2016.
 */

public class CustomScrollHeaderFooterPresenter extends AbstractPresenter<CustomScrollHeaderFooterContract.View> implements CustomScrollHeaderFooterContract.Presenter {

    private AdapterHeaderFooterContract.View adapterView;
    private AdapterHeaderFooterContract.Model<LocalImage, LocalImage, Objects> adapterModel;

    private ImagesMetaLocalRepository metaLocalRepository;

    @Override
    public void setAdapterView(AdapterHeaderFooterContract.View adapterView) {
        this.adapterView = adapterView;
    }

    @Override
    public void setAdapterModel(AdapterHeaderFooterContract.Model<LocalImage, LocalImage, Objects> adapterModel) {
        this.adapterModel = adapterModel;
    }

    @Override
    public void setMetaLocalRepository(ImagesMetaLocalRepository metaLocalRepository) {
        this.metaLocalRepository = metaLocalRepository;
    }

    @Override
    public void loadImage() {
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

    @Override
    public void loadHeader() {
        adapterModel.setHeaderItem(null);
    }

    @Override
    public void loadFooter() {
        adapterModel.setFooterItem(null);
    }
}
