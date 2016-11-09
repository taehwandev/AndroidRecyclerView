package tech.thdev.androidrecyclerview.adapter.model;

import tech.thdev.support.widget.adapter.model.BaseRecyclerModel;
import tech.thdev.support.widget.data.BaseItem;

/**
 * Created by Tae-hwan on 10/10/2016.
 */

public interface AdapterContract {

    interface View {

        void reload();
    }

    interface Model<T extends BaseItem> extends BaseRecyclerModel<T> {

    }
}
