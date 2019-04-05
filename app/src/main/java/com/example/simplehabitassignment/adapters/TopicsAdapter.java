package com.example.simplehabitassignment.adapters;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.simplehabitassignment.R;
import com.example.simplehabitassignment.data.vos.TopicsVO;
import com.example.simplehabitassignment.views.pods.holders.TopicsViewHolder;

public class TopicsAdapter extends BaseRecyclerAdapter <TopicsViewHolder, TopicsVO> {

    @NonNull
    @Override
    public TopicsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.view_item_topics, viewGroup, false);
        return new TopicsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopicsViewHolder holder, int position) {
        TextView tvTopicTitle, tvTitleDescription;
        ImageView ivTopicIcon, ivTopicDescription;

        tvTopicTitle = holder.itemView.findViewById(R.id.tv_topic_title);
        tvTitleDescription = holder.itemView.findViewById(R.id.tv_topic_description);


        tvTopicTitle.setText(getItems().get(position).getTopicName());
        tvTitleDescription.setText(getItems().get(position).getTopicDesc());


    }
}

