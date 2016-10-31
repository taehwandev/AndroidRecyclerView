package tech.thdev.androidrecyclerview.view.scroll.anim;

import android.animation.ObjectAnimator;
import android.support.annotation.IntDef;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import tech.thdev.androidrecyclerview.MyApplication;
import tech.thdev.androidrecyclerview.view.animation.AnimatorEvent;
import tech.thdev.androidrecyclerview.view.animation.ItemAnimatorEvent;

/**
 * Created by Tae-hwan on 19/10/2016.
 */

public class OnRecyclerScrollListener extends RecyclerView.OnScrollListener {

    private final static int SCROLL_NONE = 0;
    private final static int SCROLL_UP = 1;
    private final static int SCROLL_DOWN = 2;

    @IntDef({SCROLL_NONE, SCROLL_UP, SCROLL_DOWN})
    @interface ScrollType {
    }

    public final static int DEFAULT_DURATION = 400;

    private final static boolean DEBUG = true;

    private int duration;

    private int prevScrollEvent = SCROLL_NONE;

    private Disposable animDisposable;

    private final ArrayList<AnimView> animViewList = new ArrayList<>();
    private final List<Observable<Boolean>> animObservableList = new ArrayList<>();


    public OnRecyclerScrollListener() {
        this(DEFAULT_DURATION);
    }

    public OnRecyclerScrollListener(int duration) {
        this.duration = duration;
    }


    public final void addView(View view, int translation) {
        animViewList.add(new AnimView(view, translation));
    }

    public final void destroy() {
        animViewList.clear();

        if (animDisposable != null) {
            animDisposable.dispose();
            animDisposable = null;
        }

        animObservableList.clear();

        prevScrollEvent = SCROLL_NONE;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        if (dy < 0) { // UP
            startAnimation(SCROLL_UP);
        } else if (dy > 0) { // DOWN
            startAnimation(SCROLL_DOWN);
        } else {
            startAnimation(SCROLL_NONE);
        }
    }

    private void startAnimation(@ScrollType final int scrollEvent) {
        if (scrollEvent == prevScrollEvent) {
            return;
        }

        // Prev animation release
        if (animDisposable != null) {
            animDisposable.dispose();
            animDisposable = null;

            prevScrollEvent = scrollEvent;
        }

        Observable.fromIterable(animViewList)
                .subscribe(new Consumer<AnimView>() {
                    @Override
                    public void accept(AnimView animView) throws Exception {
                        if (animView.getView() != null) {
                            addAnimation(animView, scrollEvent);
                        }
                    }
                });

        animDisposable = Observable
                .combineLatest(animObservableList, new Function<Object[], Boolean>() {
                    @Override
                    public Boolean apply(Object[] objects) throws Exception {
                        int count = 0;
                        for (Object object : objects) {
                            if ((boolean) object) {
                                ++count;
                            }
                        }
                        return count == objects.length;
                    }
                })
                .filter(new Predicate<Boolean>() {
                    @Override
                    public boolean test(Boolean aBoolean) throws Exception {
                        return aBoolean;
                    }
                })
                .doOnDispose(new Action() {
                    @Override
                    public void run() throws Exception {
                        animObservableList.clear();
                    }
                })
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        animObservableList.clear();

                        if (DEBUG) {
                            Toast.makeText(MyApplication.Companion.getAppContext(), "Anim success", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void addAnimation(AnimView animView, @ScrollType int scrollEvent) {
        switch (scrollEvent) {
            case SCROLL_UP:
                animObservableList.add(addAnimation(animView.getView(), 0));
                break;

            case SCROLL_DOWN:
                animObservableList.add(addAnimation(animView.getView(), animView.getTranslation()));
                break;

            default:
                animObservableList.add(addAnimation(animView.getView(), 0));
                break;
        }
    }

    private Observable<Boolean> addAnimation(View view, float translation) {
        final ObjectAnimator anim = ObjectAnimator.ofFloat(view, "translationY", view.getTranslationY(), translation);
        anim.setDuration(duration);
        anim.setInterpolator(new LinearInterpolator());

        return AnimatorEvent.eventObservable(anim)
                .map(new Function<ItemAnimatorEvent, Boolean>() {
                    @Override
                    public Boolean apply(ItemAnimatorEvent itemAnimatorEvent) throws Exception {
                        return itemAnimatorEvent.getEvent() == ItemAnimatorEvent.ANIM_END;
                    }
                });
    }
}
