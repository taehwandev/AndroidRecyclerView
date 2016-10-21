package tech.thdev.androidrecyclerview.view.animation;

import android.animation.Animator;

import io.reactivex.Observable;

/**
 * Created by Tae-hwan on 20/10/2016.
 */

public class AnimatorEvent {

    public static Observable<ItemAnimatorEvent> eventObservable(Animator animator) {
        return Observable.create(new AnimatorEventSubScribe(animator));
    }
}
