package tech.thdev.androidrecyclerview.ui.scroll.anim

import android.animation.ObjectAnimator
import android.util.Log
import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Tae-hwan on 19/10/2016.
 */
abstract class OnCustomScrollListener : RecyclerView.OnScrollListener() {

    private var viewOne: View? = null
    private var viewOneTranslation = 0
    private var viewTwo: View? = null
    private var viewTwoTranslation = 0

    fun setViewOne(viewOne: View?, viewOneTranslation: Int) {
        this.viewOne = viewOne
        this.viewOneTranslation = viewOneTranslation
    }

    fun setViewTwo(viewTwo: View?, viewTwoTranslation: Int) {
        this.viewTwo = viewTwo
        this.viewTwoTranslation = viewTwoTranslation
    }

    fun init() {
        if (viewOne != null) {
            doAnimationView(viewOne!!, 0)
        }
        if (viewTwo != null) {
            doAnimationView(viewTwo!!, 0)
        }
    }

    private fun scrollUp() {
        if (viewOne != null && viewOne!!.translationY != 0f) {
            doAnimationView(viewOne!!, 0)
        }
        if (viewTwo != null && viewTwo!!.translationY != 0f) {
            doAnimationView(viewTwo!!, 0)
        }
    }

    private fun scrollDown() {
        if (viewOne != null && viewOne!!.translationY == 0f) {
            doAnimationView(viewOne!!, viewOneTranslation)
        }
        if (viewTwo != null && viewTwo!!.translationY == 0f) {
            doAnimationView(viewTwo!!, viewTwoTranslation)
        }
    }

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        Log.i("TAG", "onScrolled : $dx, dy : $dy")
        if (dy < 0) { // UP
            scrollUp()
        } else if (dy > 0) { // DOWN
            scrollDown()
        } else {
            init()
        }
    }

    override fun onScrollStateChanged(
        recyclerView: RecyclerView,
        newState: Int
    ) {
        super.onScrollStateChanged(recyclerView, newState)
        Log.d("TAG", "onScrollStateChanged : $newState")
        Log.d("TAG", "SCROLL_STATE_IDLE : " + RecyclerView.SCROLL_STATE_IDLE)
        Log.d("TAG", "SCROLL_STATE_IDLE : " + RecyclerView.SCROLL_STATE_DRAGGING)
        Log.d("TAG", "SCROLL_STATE_IDLE : " + RecyclerView.SCROLL_STATE_SETTLING)
    }

    fun doAnimationView(view: View, trans: Int) {
        val anim =
            ObjectAnimator.ofFloat(view, "translationY", view.translationY, trans.toFloat())
        anim.duration = 400
        anim.interpolator = LinearInterpolator()
        anim.start()
    }
}