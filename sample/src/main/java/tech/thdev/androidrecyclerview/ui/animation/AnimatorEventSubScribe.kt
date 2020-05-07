package tech.thdev.androidrecyclerview.ui.animation

import android.animation.Animator
import io.reactivex.rxjava3.core.FlowableEmitter
import io.reactivex.rxjava3.core.FlowableOnSubscribe
import io.reactivex.rxjava3.disposables.Disposable

/**
 * Created by Tae-hwan on 20/10/2016.
 */
class AnimatorEventSubScribe(private val animator: Animator) :
    FlowableOnSubscribe<ItemAnimatorEvent> {

    @Throws(Exception::class)
    override fun subscribe(emitter: FlowableEmitter<ItemAnimatorEvent>?) {
        val listener = object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) = Unit

            override fun onAnimationEnd(animation: Animator?) {
                if (emitter?.isCancelled != true && animation != null) {
                    emitter?.onNext(
                        ItemAnimatorEvent.eventCreate(
                            animation,
                            ItemAnimatorEvent.ANIM_END
                        )
                    )
                }
            }

            override fun onAnimationCancel(animation: Animator?) = Unit

            override fun onAnimationStart(animation: Animator?) {
                if (emitter?.isCancelled != true && animation != null) {
                    emitter?.onNext(
                        ItemAnimatorEvent.eventCreate(
                            animation,
                            ItemAnimatorEvent.ANIM_START
                        )
                    )
                }
            }
        }

        animator.addListener(listener)
        animator.start()
        emitter?.setDisposable(object : Disposable {
            override fun isDisposed(): Boolean = true

            override fun dispose() {
                animator.cancel()
                animator.removeAllListeners()
            }
        })
    }
}