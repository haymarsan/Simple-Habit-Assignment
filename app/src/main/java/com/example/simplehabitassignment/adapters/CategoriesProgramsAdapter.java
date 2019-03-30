package com.example.simplehabitassignment.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.simplehabitassignment.R;
import com.example.simplehabitassignment.data.vos.CategoriesAndProgramsVO;
import com.example.simplehabitassignment.delegates.CategoriesProgramsItemDelegate;
import com.example.simplehabitassignment.views.pods.holders.CategoriesProgramsViewHolder;


public class CategoriesProgramsAdapter extends BaseRecyclerAdapter<CategoriesProgramsViewHolder, CategoriesAndProgramsVO> {


    CategoriesProgramsItemDelegate mDelegate;
    public CategoriesProgramsAdapter(CategoriesProgramsItemDelegate delegate) {
        this.mDelegate = delegate;
    }

    @NonNull
    @Override
    public CategoriesProgramsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.view_item_categories_programs,viewGroup,false);

        return new CategoriesProgramsViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull CategoriesProgramsViewHolder holder, int position) {

        RecyclerView recyclerView = holder.itemView.findViewById(R.id.rv_programs);
        ProgramsAdapter programsAdapter = new ProgramsAdapter(mDelegate);
        recyclerView.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext()
                , LinearLayoutManager.HORIZONTAL,false));

        recyclerView.setAdapter(programsAdapter);

        TextView tvTitle = holder.itemView.findViewById(R.id.tv_title);
        tvTitle.setText(getItems().get(position).getTitle());

        programsAdapter.setNewData(getItems().get(position).getProgramsList());
    }


}
