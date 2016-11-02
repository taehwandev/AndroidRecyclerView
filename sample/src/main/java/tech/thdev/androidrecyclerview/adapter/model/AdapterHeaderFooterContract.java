package tech.thdev.androidrecyclerview.adapter.model;

import tech.thdev.support.widget.adapter.header_footer.model.BaseHeaderFooterRecyclerModel;
import tech.thdev.support.widget.data.BaseItem;

/**
 * Created by Tae-hwan on 01/11/2016.
 */

public interface AdapterHeaderFooterContract {

    interface View {

        void reload();
    }

    interface Model<ITEM extends BaseItem, HEADER, FOOTER> extends BaseHeaderFooterRecyclerModel<ITEM, HEADER, FOOTER> {

        int getHeaderItemPosition();

        int getFooterItemPosition();
    }
}
