package tech.thdev.androidrecyclerview.listener

import tech.thdev.support.widget.adapter.simple.BaseTypedefRecyclerAdapter


/**
 * Created by Tae-hwan on 11/10/2016.
 */

interface OnItemClickListener {

    fun onItemClick(view: BaseTypedefRecyclerAdapter<*>, position: Int)
}