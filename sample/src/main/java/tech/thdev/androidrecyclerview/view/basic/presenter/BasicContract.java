package tech.thdev.androidrecyclerview.view.basic.presenter;

import tech.thdev.androidrecyclerview.adapter.model.BasicAdapterContract;
import tech.thdev.base.presenter.BasePresenter;
import tech.thdev.base.presenter.BaseView;

/**
 * Created by Tae-hwan on 11/10/2016.
 */

public interface BasicContract {

    interface View extends BaseView {

    }

    interface Presenter extends BasePresenter<View> {

        void setAdapterView(BasicAdapterContract.View adapterView);

        void setAdapterModel(BasicAdapterContract.Model adapterModel);

        void loadList();
    }
}
