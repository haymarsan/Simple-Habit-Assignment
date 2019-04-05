package com.example.simplehabitassignment.activities;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.simplehabitassignment.R;
import com.example.simplehabitassignment.adapters.SessionsAdapter;
import com.example.simplehabitassignment.data.vos.CurrentProgramVO;
import com.example.simplehabitassignment.data.vos.models.CurrentProgramModelImpl;

public class CurrentProgramDetailsActivity extends BaseActivity {

    private RecyclerView recyclerView;
    private Toolbar toolbar;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private ImageView ivBackground, ivLecturer;
    private TextView tvDescription, tvReadMore, tvLecturerName;
    private boolean expandable = true;
    private CurrentProgramVO mcurrentProgramVO;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false); // hide the toolbar

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // for back arrow
        getSupportActionBar().setDisplayShowHomeEnabled(true); // for back arrow

        mcurrentProgramVO = CurrentProgramModelImpl.getObjInstance().getMcurrentProgramVO();

        collapsingToolbarLayout = findViewById(R.id.collapsingToolBar);
        collapsingToolbarLayout.setTitle(mcurrentProgramVO.getTitle());


        recyclerView = findViewById(R.id.rv_sessions);
        SessionsAdapter sessionsAdapter = new SessionsAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(sessionsAdapter);
        sessionsAdapter.setNewData(mcurrentProgramVO.getSessionsList());

        tvDescription = findViewById(R.id.tv_description);
        tvDescription.setText(mcurrentProgramVO.getDescription());
        tvReadMore = findViewById(R.id.tv_read_more);

        tvDescription.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (expandable) {
                    expandable = false;
                    if (tvDescription.getLineCount() > 3) {
                        tvReadMore.setVisibility(View.VISIBLE);
                        ObjectAnimator animator = ObjectAnimator.ofInt(tvDescription, "maxLines", 3);
                        animator.setDuration(0).start();

                    }

                }
            }
        });


        tvReadMore.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Readmore", Toast.LENGTH_SHORT).show();


            }
        });


    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
