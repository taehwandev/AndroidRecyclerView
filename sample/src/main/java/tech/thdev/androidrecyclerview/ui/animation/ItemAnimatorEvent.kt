package tech.thdev.androidrecyclerview.ui.animation

import android.animation.Animator

/**
 * Created by Tae-hwan on 20/10/2016.
 */
class ItemAnimatorEvent private constructor(
    val animator: Animator,
    val event: Int
) {

    companion object {
        const val ANIM_START = 0
        const val ANIM_END = 1

        fun eventCreate(animator: Animator, event: Int): ItemAnimatorEvent {
            return ItemAnimatorEvent(animator, event)
        }
    }

}