package com.example.simplehabitassignment.views.pods.holders

import android.view.View
import android.widget.TextView

import com.example.simplehabitassignment.R
import com.example.simplehabitassignment.data.vos.SessionsVO


class SessionsViewHolder(itemView: View) : BaseViewHolder<SessionsVO>(itemView) {

    private var msessionsVO: SessionsVO? = null

    override fun bindData(data: SessionsVO) {

        val tvNumber: TextView
        val tvSessionName: TextView
        val tvAverageLength: TextView
        msessionsVO = data
        val totalSeconds: Long
        val minutes: Long
        val seconds: Long

        tvNumber = itemView.findViewById(R.id.tv_no)
        tvSessionName = itemView.findViewById(R.id.tv_session_name)
        tvAverageLength = itemView.findViewById(R.id.tv_average_length)



        totalSeconds = msessionsVO!!.lengthInSeconds.toLong()
        minutes = totalSeconds / 60
        seconds = totalSeconds % 60

        tvAverageLength.text = "$minutes:$seconds"

        tvSessionName.text = msessionsVO!!.title


    }


}
