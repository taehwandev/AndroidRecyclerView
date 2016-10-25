package tech.thdev.androidrecyclerview.view.design.image;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import org.jetbrains.annotations.Nullable;

import butterknife.BindView;
import tech.thdev.androidrecyclerview.R;
import tech.thdev.androidrecyclerview.adapter.image.CustomScrollImageAdapterSimpleDefinition;
import tech.thdev.androidrecyclerview.data.source.image.ImagesMetaLocalRepository;
import tech.thdev.androidrecyclerview.view.design.image.presenter.CustomScrollImageContract;
import tech.thdev.androidrecyclerview.view.design.image.presenter.CustomScrollImagePresenter;
import tech.thdev.androidrecyclerview.view.scroll.anim.OnRecyclerScrollListener;
import tech.thdev.base.view.BasePresenterFragment;

/**
 * Created by Tae-hwan on 18/10/2016.
 */

public class CustomScrollImageFragment
        extends BasePresenterFragment<CustomScrollImageContract.View, CustomScrollImageContract.Presenter>
        implements CustomScrollImageContract.View {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private RelativeLayout rlHead;
    private RelativeLayout rlBottomLayout;

    private CustomScrollImageFragment() {

    }

    public static CustomScrollImageFragment getInstance() {
        return new CustomScrollImageFragment();
    }

    @Nullable
    @Override
    public CustomScrollImageContract.Presenter onCreatePresenter() {
        return new CustomScrollImagePresenter();
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_recycler_view;
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

        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(onCustomScrollListener);

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
        if (recyclerView != null) {
            onCustomScrollListener.destroy();
            recyclerView.removeOnScrollListener(onCustomScrollListener);
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
        }
    };
}
