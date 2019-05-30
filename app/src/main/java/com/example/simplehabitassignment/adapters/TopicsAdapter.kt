package com.example.simplehabitassignment.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.example.simplehabitassignment.R
import com.example.simplehabitassignment.data.vos.TopicsVO
import com.example.simplehabitassignment.views.pods.holders.TopicsViewHolder

class TopicsAdapter : BaseRecyclerAdapter<TopicsViewHolder, TopicsVO>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): TopicsViewHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        val view = inflater.inflate(R.layout.view_item_topics, viewGroup, false)
        return TopicsViewHolder(view)
    }

    override fun onBindViewHolder(holder: TopicsViewHolder, position: Int) {
        val tvTopicTitle: TextView
        val tvTitleDescription: TextView
        val ivTopicIcon: ImageView
        val ivTopicDescription: ImageView

        tvTopicTitle = holder.itemView.findViewById(R.id.tv_topic_title)
        tvTitleDescription = holder.itemView.findViewById(R.id.tv_topic_description)


        tvTopicTitle.text = items[position].topicName
        tvTitleDescription.text = items[position].topicDesc


    }
}

