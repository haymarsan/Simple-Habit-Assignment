package com.example.simplehabitassignment.views.pods.holders

import android.support.v7.widget.RecyclerView
import android.view.View

abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {


    init {
        itemView.setOnClickListener(this)
    }

    abstract fun bindData(data: T)

    override fun onClick(v: View) {

    }
}
