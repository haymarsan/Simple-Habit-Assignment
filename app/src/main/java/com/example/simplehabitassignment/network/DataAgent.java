package com.example.simplehabitassignment.network;


import com.example.simplehabitassignment.delegates.CategoriesAndProgramsResponseDelegate;
import com.example.simplehabitassignment.delegates.CurrentProgramResponseDelegate;
import com.example.simplehabitassignment.delegates.TopicsResponseDelegate;

public interface DataAgent {


    void getTopics(String accessToken, int page, TopicsResponseDelegate delegate);
    void getCategoriesAndPrograms(String accessToken, int page, CategoriesAndProgramsResponseDelegate delegate);
    void getCurrentProgram(String accessToken, int page, CurrentProgramResponseDelegate delegate);
}
