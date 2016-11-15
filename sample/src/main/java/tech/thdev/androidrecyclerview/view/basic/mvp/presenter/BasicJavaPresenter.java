package tech.thdev.androidrecyclerview.view.basic.mvp.presenter;

import android.support.v7.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import tech.thdev.base.presenter.AbstractPresenter;
import tech.thdev.support.widget.adapter.model.BaseRecyclerModel;
import tech.thdev.support.widget.adapter.model.BaseRecyclerView;
import tech.thdev.support.widget.listener.OnItemClickListener;

/**
 * Created by Tae-hwan on 11/10/2016.
 */

public class BasicJavaPresenter extends AbstractPresenter<BasicJavaContract.View>
        implements BasicJavaContract.Presenter, OnItemClickListener {

    private BaseRecyclerView adapterView;
    private BaseRecyclerModel<String> adapterModel;

    @Override
    public void loadList(int count) {
        // RxJava 1.x
//        Observable.range(1, 100)
//                .subscribeOn(AndroidSchedulers.mainThread())
//                .doOnUnsubscribe(new Action0() {
//                    @Override
//                    public void call() {
//                        adapterView.notifyDataSetChanged();
//                    }
//                })
//                .subscribe(new Action1<Integer>() {
//                    @Override
//                    public void call(Integer integer) {
//                        adapterModel.addItem("Item : " + integer);
//                    }
//                }, new Action1<Throwable>() {
//                    @Override
//                    public void call(Throwable throwable) {
//
//                    }
//                });

        // RxJava 2.
        Observable.range(1, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnComplete(new Action() {
                    @Override
                    public void run() throws Exception {
                        adapterView.notifyDataSetChanged();
                    }
                })
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        adapterModel.addItem("Item : " + integer);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }

    @Override
    public void setAdapterView(BaseRecyclerView adapterView) {
        this.adapterView = adapterView;
        this.adapterView.setOnItemClickListener(this);
    }

    @Override
    public void setAdapterModel(BaseRecyclerModel<String> adapterModel) {
        this.adapterModel = adapterModel;
    }

    @Override
    public void onItemClick(@NotNull RecyclerView.Adapter<?> adapter, int position) {
        getView().showToast(adapterModel.getItem(position));
    }
}
