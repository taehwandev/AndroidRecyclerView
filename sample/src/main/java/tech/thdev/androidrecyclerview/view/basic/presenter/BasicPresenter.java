package tech.thdev.androidrecyclerview.view.basic.presenter;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import tech.thdev.androidrecyclerview.adapter.model.BasicAdapterContract;
import tech.thdev.androidrecyclerview.data.BasicItem;
import tech.thdev.androidrecyclerview.data.MainItem;
import tech.thdev.base.presenter.AbstractPresenter;

/**
 * Created by Tae-hwan on 11/10/2016.
 */

public class BasicPresenter extends AbstractPresenter<BasicContract.View> implements BasicContract.Presenter {

    private BasicAdapterContract.View adapterView;
    private BasicAdapterContract.Model adapterModel;

    @Override
    public void loadList() {
        // RxJava 1.x
//        Observable.range(1, 100)
//                .subscribeOn(AndroidSchedulers.mainThread())
//                .doOnUnsubscribe(new Action0() {
//                    @Override
//                    public void call() {
//                        adapterView.reload();
//                    }
//                })
//                .subscribe(new Action1<Integer>() {
//                    @Override
//                    public void call(Integer integer) {
//                        adapterModel.addItem(new BasicItem("Item : " + integer, 0));
//                    }
//                }, new Action1<Throwable>() {
//                    @Override
//                    public void call(Throwable throwable) {
//
//                    }
//                });

        // RxJava 2.
        Observable.range(1, 100)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnComplete(new Action() {
                    @Override
                    public void run() throws Exception {
                        adapterView.reload();
                    }
                })
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        adapterModel.addItem(new BasicItem("Item : " + integer, 0));
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

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
