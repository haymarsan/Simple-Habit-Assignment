package com.example.simplehabitassignment.data.vos.models;

import com.example.simplehabitassignment.data.vos.TopicsVO;

import java.util.List;

public interface TopicsModel {

    void getTopics (String accessToken, int page, TopicsDelegate topicsDelegate);


    interface TopicsDelegate
    {
        void onSuccess(List<TopicsVO> topicsVO);
        void onFail(String errorMessage);

    }




}
