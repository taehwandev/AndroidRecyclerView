package tech.thdev.androidrecyclerview.view.basic.presenter;

import tech.thdev.androidrecyclerview.adapter.model.AdapterContract;
import tech.thdev.base.presenter.BasePresenter;
import tech.thdev.base.presenter.BaseView;

/**
 * Created by Tae-hwan on 11/10/2016.
 */

public interface BasicContract {

    interface View extends BaseView {

    }

    interface Presenter extends BasePresenter<View> {

        void setAdapterView(AdapterContract.View adapterView);

        void setAdapterModel(AdapterContract.Model adapterModel);

        void loadList();
    }
}
