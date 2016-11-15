package tech.thdev.androidrecyclerview.view.basic.mvp;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import org.jetbrains.annotations.Nullable;

import butterknife.BindView;
import tech.thdev.androidrecyclerview.R;
import tech.thdev.androidrecyclerview.view.basic.mvp.adapter.BasicJavaAdapter;
import tech.thdev.androidrecyclerview.view.basic.mvp.presenter.BasicJavaContract;
import tech.thdev.androidrecyclerview.view.basic.mvp.presenter.BasicJavaPresenter;
import tech.thdev.base.view.BasePresenterActivity;

/**
 * Created by Tae-hwan on 11/10/2016.
 */

public class BasicJavaActivity extends BasePresenterActivity<BasicJavaContract.View, BasicJavaContract.Presenter> implements BasicJavaContract.View {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Nullable
    @Override
    public BasicJavaContract.Presenter onCreatePresenter() {
        return new BasicJavaPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);

        BasicJavaAdapter adapter = new BasicJavaAdapter(this);
        getPresenter().setAdapterModel(adapter);
        getPresenter().setAdapterView(adapter);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);

        getPresenter().loadList(500);
    }

    @Override
    public void showToast(String item) {
        Toast.makeText(this, item, Toast.LENGTH_SHORT).show();
    }
}
