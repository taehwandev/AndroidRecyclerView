package tech.thdev.androidrecyclerview.ui.animation

import android.animation.Animator
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Flowable

/**
 * Created by Tae-hwan on 20/10/2016.
 */
object AnimatorEvent {
    fun eventObservable(animator: Animator): Flowable<ItemAnimatorEvent> {
        return Flowable.create(AnimatorEventSubScribe(animator), BackpressureStrategy.BUFFER)
    }
}