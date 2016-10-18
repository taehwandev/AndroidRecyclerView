package tech.thdev.androidrecyclerview.view.design.image.presenter;

import tech.thdev.androidrecyclerview.adapter.model.AdapterContract;
import tech.thdev.androidrecyclerview.data.LocalImage;
import tech.thdev.androidrecyclerview.data.source.image.ImagesMetaLocalRepository;
import tech.thdev.base.presenter.BasePresenter;
import tech.thdev.base.presenter.BaseView;

/**
 * Created by Tae-hwan on 18/10/2016.
 */

public interface CustomScrollImageContract {

    interface View extends BaseView {
        void showProgress();

        void hideProgress();

        void loadFail();
    }

    interface Presenter extends BasePresenter<View> {

        void setAdapterView(AdapterContract.View adapterView);

        void setAdapterModel(AdapterContract.Model<LocalImage> adapterModel);

        void setMetaLocalRepository(ImagesMetaLocalRepository metaLocalRepository);

        void updateImage();
    }
}
