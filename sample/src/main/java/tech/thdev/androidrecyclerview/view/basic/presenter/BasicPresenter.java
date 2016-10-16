package tech.thdev.androidrecyclerview.view.basic.presenter;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import tech.thdev.androidrecyclerview.adapter.model.BasicAdapterContract;
import tech.thdev.androidrecyclerview.data.BasicItem;
import tech.thdev.base.presenter.AbstractPresenter;

/**
 * Created by Tae-hwan on 11/10/2016.
 */

public class BasicPresenter extends AbstractPresenter<BasicContract.View> implements BasicContract.Presenter {

    private BasicAdapterContract.View adapterView;
    private BasicAdapterContract.Model adapterModel;

    @Override
    public void loadList() {
        Observable.range(1, 100)
                .subscribeOn(AndroidSchedulers.mainThread())
                .doOnUnsubscribe(new Action0() {
                    @Override
                    public void call() {
                        adapterView.reload();
                    }
                })
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        adapterModel.addItem(new BasicItem("Item : " + integer, 0));
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {

                    }
                });
    }

    @Override
    public void setAdapterView(BasicAdapterContract.View adapterView) {
        this.adapterView = adapterView;
    }

    @Override
    public void setAdapterModel(BasicAdapterContract.Model adapterModel) {
        this.adapterModel = adapterModel;
    }
}
