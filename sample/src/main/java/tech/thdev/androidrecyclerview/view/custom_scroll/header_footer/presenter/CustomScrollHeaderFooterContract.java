package tech.thdev.androidrecyclerview.view.custom_scroll.header_footer.presenter;

import java.util.Objects;

import tech.thdev.androidrecyclerview.adapter.model.AdapterHeaderFooterContract;
import tech.thdev.androidrecyclerview.data.LocalImage;
import tech.thdev.androidrecyclerview.data.source.image.ImagesMetaLocalRepository;
import tech.thdev.base.presenter.BasePresenter;
import tech.thdev.base.presenter.BaseView;

/**
 * Created by Tae-hwan on 18/10/2016.
 */

public interface CustomScrollHeaderFooterContract {

    interface View extends BaseView {
        void showProgress();

        void hideProgress();

        void loadFail();
    }

    interface Presenter extends BasePresenter<View> {

        void setAdapterView(AdapterHeaderFooterContract.View adapterView);

        void setAdapterModel(AdapterHeaderFooterContract.Model<LocalImage, LocalImage, Objects> adapterModel);

        void setMetaLocalRepository(ImagesMetaLocalRepository metaLocalRepository);

        void loadHeader();

        void loadFooter();

        void loadImage();
    }
}
