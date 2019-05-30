package com.example.simplehabitassignment.views.pods.holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView

import com.example.simplehabitassignment.R
import com.example.simplehabitassignment.data.vos.ProgramsVO
import com.example.simplehabitassignment.delegates.CategoriesProgramsItemDelegate


class ProgramsViewHolder(itemView: View, delegate: CategoriesProgramsItemDelegate) : BaseViewHolder<ProgramsVO>(itemView) {

    private var mProgramsVO: ProgramsVO? = null

    init {


        itemView.setOnClickListener { delegate.onTapProgram(mProgramsVO!!) }
    }

    override fun bindData(data: ProgramsVO) {

        mProgramsVO = data

        val ivProgram: ImageView
        val tvTitle = itemView.findViewById<TextView>(R.id.tv_title)
        val tvPeriod = itemView.findViewById<TextView>(R.id.tv_peroid)

        tvTitle.text = mProgramsVO!!.title
        tvPeriod.text = mProgramsVO!!.averageLengths!![0].toString() + " mins"

    }
}
