package tech.thdev.androidrecyclerview.view.custom_scroll.basic;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import org.jetbrains.annotations.Nullable;

import butterknife.BindView;
import tech.thdev.androidrecyclerview.R;
import tech.thdev.androidrecyclerview.adapter.image.CustomScrollImageAdapterSimpleDefinition;
import tech.thdev.androidrecyclerview.data.source.image.ImagesMetaLocalRepository;
import tech.thdev.androidrecyclerview.view.custom_scroll.basic.presenter.BasicCustomScrollContract;
import tech.thdev.androidrecyclerview.view.custom_scroll.basic.presenter.BasicCustomScrollPresenter;
import tech.thdev.androidrecyclerview.view.scroll.anim.OnRecyclerScrollListener;
import tech.thdev.base.view.BasePresenterFragment;

/**
 * Created by Tae-hwan on 18/10/2016.
 */

public class BasicCustomScrollFragment
        extends BasePresenterFragment<BasicCustomScrollContract.View, BasicCustomScrollContract.Presenter>
        implements BasicCustomScrollContract.View {

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    private RelativeLayout rlHead;
    private RelativeLayout rlBottomLayout;

    public static BasicCustomScrollFragment getInstance() {
        return new BasicCustomScrollFragment();
    }

    @Nullable
    @Override
    public BasicCustomScrollContract.Presenter onCreatePresenter() {
        return new BasicCustomScrollPresenter();
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_basic_custom_scroll;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rlHead = (RelativeLayout) getActivity().findViewById(R.id.rl_head);
        rlBottomLayout = (RelativeLayout) getActivity().findViewById(R.id.rl_bottom_layout);

        CustomScrollImageAdapterSimpleDefinition adapter = new CustomScrollImageAdapterSimpleDefinition(getContext());

        getPresenter().setAdapterView(adapter);
        getPresenter().setAdapterModel(adapter);
        getPresenter().setMetaLocalRepository(ImagesMetaLocalRepository.getInstance());

        mRecyclerView.setAdapter(adapter);
        mRecyclerView.addOnScrollListener(onCustomScrollListener);

        rlHead.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        onCustomScrollListener.addView(rlHead, -rlHead.getMeasuredHeight());

        rlBottomLayout.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        onCustomScrollListener.addView(rlBottomLayout, rlBottomLayout.getMeasuredHeight());

        getPresenter().updateImage();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void loadFail() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mRecyclerView != null) {
            onCustomScrollListener.destroy();
            mRecyclerView.removeOnScrollListener(onCustomScrollListener);
        }
    }

    private OnRecyclerScrollListener onCustomScrollListener = new OnRecyclerScrollListener() {

        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);

            Log.d("TAG", "computeHorizontalScrollOffset " + recyclerView.computeVerticalScrollOffset());
            Log.e("TAG", "-------------------");
        }
    };
}
