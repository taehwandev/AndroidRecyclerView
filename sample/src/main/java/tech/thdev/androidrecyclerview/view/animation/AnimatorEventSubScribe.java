package tech.thdev.androidrecyclerview.view.animation;

import android.animation.Animator;
import android.util.Log;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

/**
 * Created by Tae-hwan on 20/10/2016.
 */
public class AnimatorEventSubScribe implements ObservableOnSubscribe<ItemAnimatorEvent> {

    private Animator animator;

    public AnimatorEventSubScribe(Animator animator) {
        this.animator = animator;
    }

    @Override
    public void subscribe(final ObservableEmitter<ItemAnimatorEvent> e) throws Exception {
        final Animator.AnimatorListener listener = new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                if (!e.isDisposed()) {
                    e.onNext(ItemAnimatorEvent.eventCreate(animation, ItemAnimatorEvent.ANIM_START));
                }
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (!e.isDisposed()) {
                    e.onNext(ItemAnimatorEvent.eventCreate(animation, ItemAnimatorEvent.ANIM_END));
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        };

        animator.addListener(listener);
        animator.start();

        e.setDisposable(new Disposable() {
            @Override
            public void dispose() {
                animator.cancel();
                animator.removeAllListeners();
            }

            @Override
            public boolean isDisposed() {
                return true;
            }
        });
    }
}
