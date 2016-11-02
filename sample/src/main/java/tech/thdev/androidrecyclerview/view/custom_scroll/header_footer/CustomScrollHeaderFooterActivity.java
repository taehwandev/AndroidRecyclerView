package tech.thdev.androidrecyclerview.view.custom_scroll.header_footer;

import android.os.Bundle;
import android.support.annotation.Nullable;

import tech.thdev.androidrecyclerview.R;
import tech.thdev.base.util.ActivityUtilKt;
import tech.thdev.base.view.BaseActivity;

/**
 * Created by Tae-hwan on 01/11/2016.
 */

public class CustomScrollHeaderFooterActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_custom_scroll);

        ActivityUtilKt.replaceContentFragment(this, R.id.frame_layout, CustomScrollHeaderFooterFragment.getInstance());
    }
}
