package tech.thdev.androidrecyclerview.view.animation;

import android.animation.Animator;

/**
 * Created by Tae-hwan on 20/10/2016.
 */

public class ItemAnimatorEvent {

    public static final int ANIM_START = 0;
    public static final int ANIM_END = 1;

    private final Animator animator;
    private final int event;

    private ItemAnimatorEvent(Animator animator, int event) {
        this.animator = animator;
        this.event = event;
    }

    public static ItemAnimatorEvent eventCreate(Animator animator, int event) {
        return new ItemAnimatorEvent(animator, event);
    }


    public Animator getAnimator() {
        return animator;
    }

    public int getEvent() {
        return event;
    }
}
