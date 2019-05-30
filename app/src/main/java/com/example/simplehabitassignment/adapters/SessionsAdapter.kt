package com.example.simplehabitassignment.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.example.simplehabitassignment.R
import com.example.simplehabitassignment.data.vos.SessionsVO
import com.example.simplehabitassignment.views.pods.holders.SessionsViewHolder


class SessionsAdapter : BaseRecyclerAdapter<SessionsViewHolder, SessionsVO>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): SessionsViewHolder {


        val inflater = LayoutInflater.from(viewGroup.context)
        val view = inflater.inflate(R.layout.view_item_sessions, viewGroup, false)
        return SessionsViewHolder(view)

    }

    override fun onBindViewHolder(holder: SessionsViewHolder, position: Int) {

        val tvNo: TextView
        val tvSessionName: TextView
        val tvAverageLength: TextView
        val totalSeconds: Long
        val minutes: Long
        val seconds: Long

        tvNo = holder.itemView.findViewById(R.id.tv_no)
        tvSessionName = holder.itemView.findViewById(R.id.tv_session_name)
        tvAverageLength = holder.itemView.findViewById(R.id.tv_average_length)




        totalSeconds = items[position].lengthInSeconds.toLong()
        minutes = totalSeconds / 60
        seconds = totalSeconds % 60

        tvNo.text = (position + 1).toString() + ""

        if (seconds == 0L) {
            tvAverageLength.text = minutes.toString() + ":" + seconds + "0"
        } else {
            tvAverageLength.text = "$minutes:$seconds"
        }

        tvSessionName.text = items[position].title


    }


}
