package com.example.simplehabitassignment.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class CurrentProgramDetailsActivity extends BaseActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toast.makeText(getApplicationContext(), "CurrentProgramDetailActivity", Toast.LENGTH_SHORT).show();


    }
}
