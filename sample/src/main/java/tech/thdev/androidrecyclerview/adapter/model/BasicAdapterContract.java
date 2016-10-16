package tech.thdev.androidrecyclerview.adapter.model;

import tech.thdev.androidrecyclerview.data.BasicItem;
import tech.thdev.support.widget.adapter.model.BaseRecyclerModel;

/**
 * Created by Tae-hwan on 10/10/2016.
 */

public interface BasicAdapterContract {

    interface View {

        void reload();
    }

    interface Model extends BaseRecyclerModel<BasicItem> {

    }
}
