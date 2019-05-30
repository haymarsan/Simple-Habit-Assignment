package com.example.simplehabitassignment.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.simplehabitassignment.R
import com.example.simplehabitassignment.data.vos.ProgramsVO
import com.example.simplehabitassignment.delegates.CategoriesProgramsItemDelegate
import com.example.simplehabitassignment.views.pods.holders.ProgramsViewHolder

class ProgramsAdapter(internal var mDelegate: CategoriesProgramsItemDelegate) : BaseRecyclerAdapter<ProgramsViewHolder, ProgramsVO>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ProgramsViewHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        val view = inflater.inflate(R.layout.view_item_programs, viewGroup, false)

        return ProgramsViewHolder(view, mDelegate)
    }


}
