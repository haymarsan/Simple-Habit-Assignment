package com.example.simplehabitassignment.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.simplehabitassignment.R;
import com.example.simplehabitassignment.adapters.CategoriesProgramsAdapter;
import com.example.simplehabitassignment.adapters.TopicsAdapter;
import com.example.simplehabitassignment.data.vos.CategoriesAndProgramsVO;
import com.example.simplehabitassignment.data.vos.CurrentProgramVO;
import com.example.simplehabitassignment.data.vos.ProgramsVO;
import com.example.simplehabitassignment.data.vos.TopicsVO;
import com.example.simplehabitassignment.data.vos.models.CategoriesAndProgramsModel;
import com.example.simplehabitassignment.data.vos.models.CategoriesAndProgramsModelImpl;
import com.example.simplehabitassignment.data.vos.models.CurrentProgramModel;
import com.example.simplehabitassignment.data.vos.models.CurrentProgramModelImpl;
import com.example.simplehabitassignment.data.vos.models.TopicsModel;
import com.example.simplehabitassignment.data.vos.models.TopicsModelImpl;
import com.example.simplehabitassignment.delegates.CategoriesProgramsItemDelegate;

import java.util.List;

public class MainActivity extends AppCompatActivity implements CategoriesProgramsItemDelegate {

    private RecyclerView rvCategoriesPrograms,rvTopics;
    private CategoriesProgramsAdapter categoriesProgramsAdapter;
    private TopicsAdapter topicsAdapter;
    private ImageView ivStart;
    private TextView tvPeriod,tvTitle;
    private Button btnDay;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ivStart = findViewById(R.id.iv_overthinking_lotus);
        tvPeriod = findViewById(R.id.tv_time);
        tvTitle = findViewById(R.id.tv_title);
        btnDay = findViewById(R.id.btn_day);

        CurrentProgramModelImpl.getObjInstance().getCurrentProgram("b002c7e1a528b7cb460933fc2875e916", 1, new CurrentProgramModel.CurrentProgramDelegate() {
            @Override
            public void onSuccess(final CurrentProgramVO currentProgram) {

                tvPeriod.setText(currentProgram.getAverageLengths().get(0) +" mins");
                tvTitle.setText( currentProgram.getTitle());
                btnDay.setText(" "+currentProgram.getCurrentPeriod());
                btnDay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(MainActivity.this, CurrentProgramDetailsActivity.class);
                        startActivity(intent);

                    }
                });




            }

            @Override
            public void onFail(String errorMessage) {

            }
        });

       CategoriesAndProgramsModelImpl.getObjInstance().getCategoriesAndPrograms("b002c7e1a528b7cb460933fc2875e916", 1, new CategoriesAndProgramsModel.CategoriesAndProgramsDelegate() {
           @Override
           public void onSuccess(List<CategoriesAndProgramsVO> categoriesProgramsList) {

               categoriesProgramsAdapter.setNewData(categoriesProgramsList);

           }

           @Override
           public void onFail(String errorMessage) {

           }
       });

       // recycler view for CategoriesPrograms
        rvCategoriesPrograms = findViewById(R.id.rv_programs);
        categoriesProgramsAdapter = new CategoriesProgramsAdapter(this);
        rvCategoriesPrograms.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL,false));
        rvCategoriesPrograms.setAdapter(categoriesProgramsAdapter);



        // Call Topics API
          TopicsModelImpl.getObjInstance().getTopics("b002c7e1a528b7cb460933fc2875e916", 1, new TopicsModel.TopicsDelegate() {
              @Override
              public void onSuccess(List<TopicsVO> topicsList) {
                  topicsAdapter.setNewData(topicsList);
              }

              @Override
              public void onFail(String errorMessage) {

              }
          });






       // recycler view for Topics
       rvTopics = findViewById(R.id.rv_topics);
       topicsAdapter = new TopicsAdapter();
       rvTopics.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL,false));
       rvTopics.setAdapter(topicsAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTapProgram(ProgramsVO program) {

        Intent intent = new Intent(MainActivity.this,ProgramDetailActivity.class);
        intent.putExtra("id",program.getProgramId());
        startActivity(intent);

    }

    @Override
    public void onFail(String errorMessage) {
        Log.d("Login", "fail");
    }
}
