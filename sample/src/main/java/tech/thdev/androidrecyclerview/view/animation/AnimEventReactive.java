package tech.thdev.androidrecyclerview.view.animation;

import android.animation.Animator;
import android.view.View;

import io.reactivex.Observable;

/**
 * Created by Tae-hwan on 20/10/2016.
 */

public class AnimEventReactive {

    public static Observable<AnimEvent> eventObservable(Animator animator, View view) {
        return Observable.create(new AnimatorSubScribe(animator, view));
    }
}
