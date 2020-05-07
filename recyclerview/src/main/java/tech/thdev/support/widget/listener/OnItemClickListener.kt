package tech.thdev.support.widget.listener

import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Tae-hwan on 10/11/2016.
 */

interface OnItemClickListener {

    fun onItemClick(adapter: RecyclerView.Adapter<*>, position: Int)
}