package tech.thdev.androidrecyclerview.view.scroll.anim;

import android.view.View;

/**
 * Created by Tae-hwan on 21/10/2016.
 */

public class AnimView {

    private View view;
    private int translation;

    public AnimView(View view, int translation) {
        this.view = view;
        this.translation = translation;
    }

    public View getView() {
        return view;
    }

    public int getTranslation() {
        return translation;
    }
}
