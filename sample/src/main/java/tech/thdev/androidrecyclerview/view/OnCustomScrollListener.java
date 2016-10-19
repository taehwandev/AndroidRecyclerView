package tech.thdev.androidrecyclerview.view;

import android.animation.ObjectAnimator;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * Created by Tae-hwan on 19/10/2016.
 */

public abstract class OnCustomScrollListener extends RecyclerView.OnScrollListener {

    private View viewOne;
    private int viewOneTranslation;

    private View viewTwo;
    private int viewTwoTranslation;

    public OnCustomScrollListener() {
        super();
    }

    public final void setViewOne(View viewOne, int viewOneTranslation) {
        this.viewOne = viewOne;
        this.viewOneTranslation = viewOneTranslation;
    }

    public void setViewTwo(View viewTwo, int viewTwoTranslation) {
        this.viewTwo = viewTwo;
        this.viewTwoTranslation = viewTwoTranslation;
    }

    public void init() {
        if (viewOne != null) {
            doAnimationView(viewOne, 0);
        }

        if (viewTwo != null) {
            doAnimationView(viewTwo, 0);
        }
    }

    private void scrollUp() {
        if (viewOne != null && viewOne.getTranslationY() != 0) {
            doAnimationView(viewOne, 0);
        }

        if (viewTwo != null && viewTwo.getTranslationY() != 0) {
            doAnimationView(viewTwo, 0);
        }
    }

    private void scrollDown() {
        if (viewOne != null && viewOne.getTranslationY() == 0) {
            doAnimationView(viewOne, viewOneTranslation);
        }

        if (viewTwo != null && viewTwo.getTranslationY() == 0) {
            doAnimationView(viewTwo, viewTwoTranslation);
        }
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        Log.i("TAG", "onScrolled : " + dx + ", dy : " + dy);
        if (dy < 0) { // UP
            scrollUp();
        } else if (dy > 0) { // DOWN
            scrollDown();
        } else {
            init();
        }
    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);

        Log.d("TAG", "onScrollStateChanged : " + newState);
        Log.d("TAG", "SCROLL_STATE_IDLE : " + RecyclerView.SCROLL_STATE_IDLE);
        Log.d("TAG", "SCROLL_STATE_IDLE : " + RecyclerView.SCROLL_STATE_DRAGGING);
        Log.d("TAG", "SCROLL_STATE_IDLE : " + RecyclerView.SCROLL_STATE_SETTLING);
    }

    public void doAnimationView(final View view, final int trans) {
        ObjectAnimator anim = ObjectAnimator.ofFloat(view, "translationY", view.getTranslationY(), trans);

        anim.setDuration(400);
        anim.setInterpolator(new LinearInterpolator());
        anim.start();
    }
}
