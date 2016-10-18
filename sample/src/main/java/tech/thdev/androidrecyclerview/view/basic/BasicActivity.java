package tech.thdev.androidrecyclerview.view.basic;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import org.jetbrains.annotations.Nullable;

import butterknife.BindView;
import tech.thdev.androidrecyclerview.R;
import tech.thdev.androidrecyclerview.adapter.basic.BasicAdapter;
import tech.thdev.androidrecyclerview.view.basic.presenter.BasicContract;
import tech.thdev.androidrecyclerview.view.basic.presenter.BasicPresenter;
import tech.thdev.base.view.BasePresenterActivity;

/**
 * Created by Tae-hwan on 11/10/2016.
 */

public class BasicActivity extends BasePresenterActivity<BasicContract.View, BasicContract.Presenter> implements BasicContract.View {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        BasicAdapter adapter = new BasicAdapter(this);
        getPresenter().setAdapterModel(adapter);
        getPresenter().setAdapterView(adapter);

        getPresenter().loadList();

        recyclerView.setAdapter(adapter);
    }

    @Nullable
    @Override
    public BasicContract.Presenter onCreatePresenter() {
        return new BasicPresenter();
    }
}
