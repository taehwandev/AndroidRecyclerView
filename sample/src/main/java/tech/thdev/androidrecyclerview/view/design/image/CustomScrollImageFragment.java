package tech.thdev.androidrecyclerview.view.design.image;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.jetbrains.annotations.Nullable;

import butterknife.BindView;
import tech.thdev.androidrecyclerview.R;
import tech.thdev.androidrecyclerview.adapter.image.CustomScrollImageAdapter;
import tech.thdev.androidrecyclerview.data.source.image.ImagesMetaLocalRepository;
import tech.thdev.androidrecyclerview.view.design.image.presenter.CustomScrollImageContract;
import tech.thdev.androidrecyclerview.view.design.image.presenter.CustomScrollImagePresenter;
import tech.thdev.base.view.BasePresenterFragment;

/**
 * Created by Tae-hwan on 18/10/2016.
 */

public class CustomScrollImageFragment
        extends BasePresenterFragment<CustomScrollImageContract.View, CustomScrollImageContract.Presenter>
        implements CustomScrollImageContract.View {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

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

        CustomScrollImageAdapter adapter = new CustomScrollImageAdapter(getContext());

        getPresenter().setAdapterView(adapter);
        getPresenter().setAdapterModel(adapter);
        getPresenter().setMetaLocalRepository(ImagesMetaLocalRepository.getInstance());

        recyclerView.setAdapter(adapter);

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
}
