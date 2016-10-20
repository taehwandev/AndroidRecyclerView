package tech.thdev.androidrecyclerview.view.animation;

import android.animation.Animator;
import android.view.View;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/**
 * Created by Tae-hwan on 20/10/2016.
 */
public class AnimatorSubScribe implements ObservableOnSubscribe<AnimEvent> {

    private Animator animator;
    private View view;

    public AnimatorSubScribe(Animator animator, View view) {
        this.animator = animator;
        this.view = view;
    }

    @Override
    public void subscribe(final ObservableEmitter<AnimEvent> e) throws Exception {
        Animator.AnimatorListener listener = new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                if (!e.isCancelled()) {
                    e.onNext(AnimEvent.eventCreate(animation, AnimEvent.ANIM_START));
                }
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (!e.isCancelled()) {
                    e.onNext(AnimEvent.eventCreate(animation, AnimEvent.ANIM_END));
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
    }
}
