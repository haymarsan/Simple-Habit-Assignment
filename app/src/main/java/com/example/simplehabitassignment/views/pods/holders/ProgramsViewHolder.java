package com.example.simplehabitassignment.views.pods.holders;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.simplehabitassignment.R;
import com.example.simplehabitassignment.data.vos.ProgramsVO;
import com.example.simplehabitassignment.delegates.CategoriesProgramsItemDelegate;


public class ProgramsViewHolder extends BaseViewHolder<ProgramsVO> {

    private ProgramsVO mProgramsVO;
    public ProgramsViewHolder(@NonNull View itemView, final CategoriesProgramsItemDelegate delegate) {
        super(itemView);


        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               delegate.onTapProgram(mProgramsVO);

            }
        });
    }

    @Override
    public void bindData(ProgramsVO data) {

        mProgramsVO = data;

        ImageView ivProgram;
        TextView tvTitle = itemView.findViewById(R.id.tv_title);
        TextView tvPeriod = itemView.findViewById(R.id.tv_peroid);

        tvTitle.setText(mProgramsVO.getTitle());
        tvPeriod.setText(mProgramsVO.getAverageLengths().get(0) + " mins");

    }
}
