package tech.thdev.androidrecyclerview.view;

import android.animation.ObjectAnimator;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import tech.thdev.androidrecyclerview.MyApplication;
import tech.thdev.androidrecyclerview.view.animation.AnimEvent;
import tech.thdev.androidrecyclerview.view.animation.AnimEventReactive;

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
//        Observable.just(item)
//                .subscribe(new Consumer<Item>() {
//
//                    @Override
//                    public void accept(Item item) throws Exception {
//
//                    }
//                });
//
//        final ObjectAnimator anim = ObjectAnimator.ofFloat(item.view, "translationY", item.view.getTranslationY(), item.translation);
//
//        anim.setDuration(400);
//        anim.setInterpolator(new LinearInterpolator());
//
//        ObservableSource<Boolean> source = AnimEventReactive.eventObservable(anim, item.view)
//                .map(new Function<AnimEvent, Boolean>() {
//                    @Override
//                    public Boolean apply(AnimEvent animEvent) throws Exception {
//                        return animEvent.getEvent() == AnimEvent.ANIM_END;
//                    }
//                });

//        Observable.combineLatest(source, source, new BiFunction() {
//            @Override
//            public Object apply(Object o, Object o2) throws Exception {
//                return o == o2;
//            }
//        }).subscribe(new Consumer() {
//            @Override
//            public void accept(Object o) throws Exception {
//                Toast.makeText(MyApplication.Companion.getAppContext(), "Success", Toast.LENGTH_SHORT).show();
//            }
//        });
        List<ObservableSource<Boolean>> test = new ArrayList<>();

        final ObjectAnimator anim = ObjectAnimator.ofFloat(item.view, "translationY", item.view.getTranslationY(), item.translation);
        anim.setDuration(400);
        anim.setInterpolator(new LinearInterpolator());
        ObservableSource<Boolean> source = AnimEventReactive.eventObservable(anim, item.view)
                .map(new Function<AnimEvent, Boolean>() {
                    @Override
                    public Boolean apply(AnimEvent animEvent) throws Exception {
                        return animEvent.getEvent() == AnimEvent.ANIM_END;
                    }
                });

        test.add(source);
        test.add(source);
        test.add(source);
        Observable.combineLatest(test, new Function<Object[], Boolean>() {
            @Override
            public Boolean apply(Object[] objects) throws Exception {
                Log.d("TAG", "booleenSize : " + objects.length);
                int count = 0;
                for (Object object : objects) {
                    if ((Boolean) object) {
                        ++count;
                    }
                }
                return count == objects.length;
            }
        }).filter(new Predicate<Boolean>() {
            @Override
            public boolean test(Boolean aBoolean) throws Exception {
                return aBoolean;
            }
        }).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                Toast.makeText(MyApplication.Companion.getAppContext(), "End", Toast.LENGTH_SHORT).show();
            }
        });
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
