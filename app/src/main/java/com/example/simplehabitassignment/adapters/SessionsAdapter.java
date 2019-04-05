package com.example.simplehabitassignment.adapters;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.simplehabitassignment.R;
import com.example.simplehabitassignment.data.vos.SessionsVO;
import com.example.simplehabitassignment.views.pods.holders.SessionsViewHolder;


public class SessionsAdapter extends BaseRecyclerAdapter<SessionsViewHolder, SessionsVO> {

    @NonNull
    @Override
    public SessionsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.view_item_sessions,viewGroup,false);
        return new SessionsViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull SessionsViewHolder holder, int position) {

        TextView tvNo, tvSessionName, tvAverageLength;
        long totalSeconds,minutes,seconds;

        tvNo = holder.itemView.findViewById(R.id.tv_no);
        tvSessionName = holder.itemView.findViewById(R.id.tv_session_name);
        tvAverageLength = holder.itemView.findViewById(R.id.tv_average_length);




        totalSeconds = getItems().get(position).getLengthInSeconds();
        minutes = totalSeconds / 60;
        seconds = totalSeconds % 60;

        tvNo.setText((position + 1 )+ "");

        if(seconds == 0)
        {
            tvAverageLength.setText(minutes + ":" + seconds+"0");
        }
        else
        {
            tvAverageLength.setText(minutes + ":" + seconds);
        }

        tvSessionName.setText(getItems().get(position).getTitle());


    }


}
