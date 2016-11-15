package tech.thdev.androidrecyclerview.view.basic.mvp.presenter;

import tech.thdev.base.presenter.BasePresenter;
import tech.thdev.base.presenter.BaseView;
import tech.thdev.support.widget.adapter.model.BaseRecyclerModel;
import tech.thdev.support.widget.adapter.model.BaseRecyclerView;

/**
 * Created by Tae-hwan on 11/10/2016.
 */

public interface BasicJavaContract {

    interface View extends BaseView {

        void showToast(String item);
    }

    interface Presenter extends BasePresenter<View> {

        void setAdapterView(BaseRecyclerView adapterView);

        void setAdapterModel(BaseRecyclerModel<String> adapterModel);

        void loadList(int count);
    }
}
