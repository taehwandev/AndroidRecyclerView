package tech.thdev.androidrecyclerview.view.design.image;

import android.os.Bundle;
import android.support.annotation.Nullable;

import tech.thdev.androidrecyclerview.R;
import tech.thdev.base.util.ActivityUtilKt;
import tech.thdev.base.view.BaseActivity;

/**
 * Created by Tae-hwan on 18/10/2016.
 */

public class CustomScrollImageActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_scroll_image);

        ActivityUtilKt.replaceContentFragment(this, R.id.frame_layout, CustomScrollImageFragment.getInstance());
    }
}
