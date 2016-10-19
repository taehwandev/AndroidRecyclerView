package tech.thdev.androidrecyclerview.view;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Created by Tae-hwan on 19/10/2016.
 */

public class OnRecyclerScrollListener extends RecyclerView.OnScrollListener {

    class Item {
        View view;
        int translation;

        Item(View view, int translation) {
            this.view = view;
            this.translation = translation;
        }
    }

    private ArrayList<Item> list = new ArrayList<>();

    public OnRecyclerScrollListener() {
        super();
    }

    public final void setView(View view, int translation) {
        list.add(new Item(view, translation));
    }

    public void init() {
        Item item = list.get(0);
        Observable.just(item)
                .subscribe(new Consumer<Item>() {
                    @Override
                    public void accept(Item item) throws Exception {

                    }
                });
        // TODO Rx...
    }

    private void scrollUp() {
        // TODO Rx...
    }

    private void scrollDown() {
        // TODO Rx...
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        Log.i("TAG", "onScrolled : " + dx + ", dy : " + dy);
        if (dy < 0) { // UP
            scrollUp();
        } else if (dy > 0) { // DOWN
            scrollDown();
        } else {
            init();
        }
    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);

        Log.d("TAG", "onScrollStateChanged : " + newState);
        Log.d("TAG", "SCROLL_STATE_IDLE : " + RecyclerView.SCROLL_STATE_IDLE);
        Log.d("TAG", "SCROLL_STATE_IDLE : " + RecyclerView.SCROLL_STATE_DRAGGING);
        Log.d("TAG", "SCROLL_STATE_IDLE : " + RecyclerView.SCROLL_STATE_SETTLING);
    }
}
