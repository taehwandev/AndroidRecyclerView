package tech.thdev.androidrecyclerview.view.animation;

import android.animation.Animator;

/**
 * Created by Tae-hwan on 20/10/2016.
 */

public class AnimEvent {

    public static final int ANIM_START = 0;
    public static final int ANIM_END = 1;

    private final Animator animator;
    private final int event;

    private AnimEvent(Animator animator, int event) {
        this.animator = animator;
        this.event = event;
    }

    public static AnimEvent eventCreate(Animator animator, int event) {
        return new AnimEvent(animator, event);
    }


    public Animator getAnimator() {
        return animator;
    }

    public int getEvent() {
        return event;
    }
}
