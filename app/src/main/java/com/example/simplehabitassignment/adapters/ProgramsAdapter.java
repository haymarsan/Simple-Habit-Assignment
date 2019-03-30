package com.example.simplehabitassignment.adapters;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.simplehabitassignment.R;
import com.example.simplehabitassignment.data.vos.ProgramsVO;
import com.example.simplehabitassignment.delegates.CategoriesProgramsItemDelegate;
import com.example.simplehabitassignment.views.pods.holders.ProgramsViewHolder;

public class ProgramsAdapter extends BaseRecyclerAdapter<ProgramsViewHolder, ProgramsVO> {


    CategoriesProgramsItemDelegate mDelegate;
    public ProgramsAdapter(CategoriesProgramsItemDelegate delegate) {
        this.mDelegate = delegate;
    }


    @NonNull
    @Override
    public ProgramsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.view_item_programs,viewGroup,false);

        return new ProgramsViewHolder(view,mDelegate);
    }



}
