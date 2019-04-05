package com.example.simplehabitassignment.activities;

import android.animation.ObjectAnimator;
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
import com.example.simplehabitassignment.data.vos.ProgramsVO;
import com.example.simplehabitassignment.data.vos.models.CategoriesAndProgramsModelImpl;

public class ProgramDetailActivity extends BaseActivity {


    private RecyclerView recyclerView;
    private Toolbar toolbar;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private ImageView ivBackground,ivLecturer;
    private TextView tvDescription, tvReadMore,tvLecturerName;
    private  boolean expandable = true;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false); // hide the toolbar

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // for back arrow
        getSupportActionBar().setDisplayShowHomeEnabled(true); // for back arrow



        collapsingToolbarLayout = findViewById(R.id.collapsingToolBar);
        tvDescription = findViewById(R.id.tv_description);

        // collapsingToolbarLayout.setTitle("Unlock Your Full Potential");
        /*collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(R.color.transparent));
        collapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.white));*/

        // collapsingToolbarLayout.setCollapsedTitleTextAppearance(getResources().getDimensionPixelOffset(R.dimen.text_regular));

        String id = getIntent().getStringExtra("id");
        ProgramsVO programsVO = CategoriesAndProgramsModelImpl.getObjInstance().getProgramById(id);


        collapsingToolbarLayout.setTitle(programsVO.getTitle());
        tvDescription.setText(programsVO.getDescription());


        recyclerView = findViewById(R.id.rv_sessions);
        SessionsAdapter sessionsAdapter = new SessionsAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(sessionsAdapter);
        sessionsAdapter.setNewData(programsVO.getSessionsList());

        tvDescription = findViewById(R.id.tv_description);
        tvReadMore = findViewById(R.id.tv_read_more);

        tvDescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Description", Toast.LENGTH_SHORT).show();
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
