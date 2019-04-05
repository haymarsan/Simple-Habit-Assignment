package com.example.simplehabitassignment.views.pods.holders;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.example.simplehabitassignment.R;
import com.example.simplehabitassignment.data.vos.SessionsVO;


public class SessionsViewHolder extends BaseViewHolder<SessionsVO> {

    private SessionsVO msessionsVO;

    public SessionsViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    @Override
    public void bindData(SessionsVO data) {

        TextView tvNumber, tvSessionName, tvAverageLength;
        msessionsVO = data;
        long totalSeconds,minutes,seconds;

        tvNumber = itemView.findViewById(R.id.tv_no);
        tvSessionName = itemView.findViewById(R.id.tv_session_name);
        tvAverageLength = itemView.findViewById(R.id.tv_average_length);



        totalSeconds = msessionsVO.getLengthInSeconds();
        minutes = totalSeconds / 60;
        seconds = totalSeconds % 60;

        tvAverageLength.setText(minutes + ":" + seconds);

        tvSessionName.setText(msessionsVO.getTitle());





    }


}
