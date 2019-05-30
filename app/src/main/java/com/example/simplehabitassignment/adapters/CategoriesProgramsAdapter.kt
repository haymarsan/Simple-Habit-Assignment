package com.example.simplehabitassignment.adapters

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.example.simplehabitassignment.R
import com.example.simplehabitassignment.data.vos.CategoriesAndProgramsVO
import com.example.simplehabitassignment.delegates.CategoriesProgramsItemDelegate
import com.example.simplehabitassignment.views.pods.holders.CategoriesProgramsViewHolder


class CategoriesProgramsAdapter(internal var mDelegate: CategoriesProgramsItemDelegate) : BaseRecyclerAdapter<CategoriesProgramsViewHolder, CategoriesAndProgramsVO>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): CategoriesProgramsViewHolder {

        val inflater = LayoutInflater.from(viewGroup.context)
        val view = inflater.inflate(R.layout.view_item_categories_programs, viewGroup, false)

        return CategoriesProgramsViewHolder(view)
    }


    override fun onBindViewHolder(holder: CategoriesProgramsViewHolder, position: Int) {

        val recyclerView = holder.itemView.findViewById<RecyclerView>(R.id.rv_programs)
        val programsAdapter = ProgramsAdapter(mDelegate)
        recyclerView.layoutManager = LinearLayoutManager(holder.itemView.context, LinearLayoutManager.HORIZONTAL, false)

        recyclerView.adapter = programsAdapter

        val tvTitle = holder.itemView.findViewById<TextView>(R.id.tv_title)
        tvTitle.text = items[position].title

        programsAdapter.setNewData(items[position].programsList)
    }


}
