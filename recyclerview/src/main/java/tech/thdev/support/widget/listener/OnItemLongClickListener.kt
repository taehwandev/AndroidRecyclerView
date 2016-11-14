package tech.thdev.support.widget.listener

import android.support.v7.widget.RecyclerView

/**
 * Created by Tae-hwan on 10/11/2016.
 */

interface OnItemLongClickListener {

    fun onItemLongClick(adapter: RecyclerView.Adapter<*>, position: Int): Boolean
}