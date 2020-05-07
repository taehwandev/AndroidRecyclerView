package tech.thdev.androidrecyclerview.ui.scroll.anim

import android.animation.ObjectAnimator
import android.util.Log
import android.view.View
import android.view.animation.LinearInterpolator
import android.widget.Toast
import androidx.annotation.IntDef
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.disposables.Disposable
import tech.thdev.androidrecyclerview.MyApplication.Companion.appContext
import tech.thdev.androidrecyclerview.ui.animation.AnimatorEvent.eventObservable
import tech.thdev.androidrecyclerview.ui.animation.ItemAnimatorEvent
import java.util.*

/**
 * Created by Tae-hwan on 19/10/2016.
 */
open class OnRecyclerScrollListener @JvmOverloads constructor(
    private val duration: Int = DEFAULT_DURATION
) : RecyclerView.OnScrollListener() {

    companion object {
        private const val SCROLL_NONE = 0
        private const val SCROLL_UP = 1
        private const val SCROLL_DOWN = 2
        const val DEFAULT_DURATION = 400
        private const val DEBUG = true
    }

    @IntDef(
        SCROLL_NONE,
        SCROLL_UP,
        SCROLL_DOWN
    )
    internal annotation class ScrollType

    private var prevScrollEvent = SCROLL_NONE
    private var animDisposable: Disposable? = null
    private val animViewList = ArrayList<AnimView>()
    private val animObservableList: MutableList<Flowable<Boolean>> =
        ArrayList()

    fun addView(view: View?, translation: Int) {
        animViewList.add(AnimView(view!!, translation))
    }

    fun destroy() {
        animViewList.clear()
        if (animDisposable != null) {
            animDisposable!!.dispose()
            animDisposable = null
        }
        animObservableList.clear()
        prevScrollEvent = SCROLL_NONE
    }

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        if (dy < 0) { // UP
            startAnimation(SCROLL_UP)
        } else if (dy > 0) { // DOWN
            startAnimation(SCROLL_DOWN)
        } else {
            startAnimation(SCROLL_NONE)
        }
    }

    private fun startAnimation(@ScrollType scrollEvent: Int) {
        if (scrollEvent == prevScrollEvent) {
            return
        }

        // Prev animation release
        if (animDisposable != null) {
            animDisposable!!.dispose()
            animDisposable = null
            prevScrollEvent = scrollEvent
        }
        Flowable.fromIterable(animViewList)
            .subscribe { animView: AnimView ->
                addAnimation(
                    animView,
                    scrollEvent
                )
            }
        animDisposable = Flowable
            .combineLatest(
                animObservableList
            ) { objects ->
                var count = 0
                for (`object` in objects) {
                    if (`object` as Boolean) {
                        ++count
                    }
                }
                Log.i("TAG", "-------- count $count")
                count == objects.size
            }
            .filter { aBoolean: Boolean? -> aBoolean!! }
            .doOnCancel { animObservableList.clear() }
            .subscribe { aBoolean: Boolean? ->
                animObservableList.clear()
                if (DEBUG) {
                    Toast.makeText(
                        appContext,
                        "Anim success",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }

    private fun addAnimation(animView: AnimView, @ScrollType scrollEvent: Int) {
        when (scrollEvent) {
            SCROLL_UP -> animObservableList.add(
                addAnimation(
                    animView.view,
                    0f
                )
            )
            SCROLL_DOWN -> animObservableList.add(
                addAnimation(
                    animView.view,
                    animView.translation.toFloat()
                )
            )
            else -> animObservableList.add(addAnimation(animView.view, 0f))
        }
    }

    private fun addAnimation(
        view: View,
        translation: Float
    ): Flowable<Boolean> {
        val anim =
            ObjectAnimator.ofFloat(view, "translationY", view.translationY, translation)
        anim.duration = duration.toLong()
        anim.interpolator = LinearInterpolator()
        return eventObservable(anim)
            .map { itemAnimatorEvent -> itemAnimatorEvent.event == ItemAnimatorEvent.ANIM_END }
    }
}