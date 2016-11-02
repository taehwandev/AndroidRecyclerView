package tech.thdev.androidrecyclerview.view.custom_scroll.header_footer;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import org.jetbrains.annotations.Nullable;

import butterknife.BindView;
import tech.thdev.androidrecyclerview.R;
import tech.thdev.androidrecyclerview.adapter.header_footer.CustomScrollHeaderFooterAdapter;
import tech.thdev.androidrecyclerview.data.source.image.ImagesMetaLocalRepository;
import tech.thdev.androidrecyclerview.view.custom_scroll.header_footer.presenter.CustomScrollHeaderFooterContract;
import tech.thdev.androidrecyclerview.view.custom_scroll.header_footer.presenter.CustomScrollHeaderFooterPresenter;
import tech.thdev.androidrecyclerview.view.scroll.anim.OnRecyclerScrollListener;
import tech.thdev.base.view.BasePresenterFragment;

/**
 * Created by Tae-hwan on 18/10/2016.
 */

public class CustomScrollHeaderFooterFragment
        extends BasePresenterFragment<CustomScrollHeaderFooterContract.View, CustomScrollHeaderFooterContract.Presenter>
        implements CustomScrollHeaderFooterContract.View {

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    private RelativeLayout rlHead;
    private RelativeLayout rlBottomLayout;

    private GridLayoutManager manager;

    public static CustomScrollHeaderFooterFragment getInstance() {
        return new CustomScrollHeaderFooterFragment();
    }

    @Nullable
    @Override
    public CustomScrollHeaderFooterContract.Presenter onCreatePresenter() {
        return new CustomScrollHeaderFooterPresenter();
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_custom_scroll_header_footer;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rlHead = (RelativeLayout) getActivity().findViewById(R.id.rl_head);
        rlBottomLayout = (RelativeLayout) getActivity().findViewById(R.id.rl_bottom_layout);

        final CustomScrollHeaderFooterAdapter adapter = new CustomScrollHeaderFooterAdapter(getContext());

        getPresenter().setAdapterView(adapter);
        getPresenter().setAdapterModel(adapter);
        getPresenter().setMetaLocalRepository(ImagesMetaLocalRepository.getInstance());

        manager = new GridLayoutManager(getContext(), 2);

        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return adapter.hasHeaderItems(position) || adapter.hasFooterItem(position) ? manager.getSpanCount() : 1;
            }
        });

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.addOnScrollListener(onCustomScrollListener);

        rlHead.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        onCustomScrollListener.addView(rlHead, -rlHead.getMeasuredHeight());

        rlBottomLayout.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        onCustomScrollListener.addView(rlBottomLayout, rlBottomLayout.getMeasuredHeight());

        getPresenter().loadHeader();
        getPresenter().loadFooter();
        getPresenter().loadImage();
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
