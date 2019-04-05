package com.example.simplehabitassignment.data.vos.models;

import com.example.simplehabitassignment.data.vos.TopicsVO;
import com.example.simplehabitassignment.delegates.TopicsResponseDelegate;
import com.example.simplehabitassignment.network.DataAgent;
import com.example.simplehabitassignment.network.RetrofitDA;

import java.util.List;

public class TopicsModelImpl implements TopicsModel {

    private static TopicsModelImpl objInstance;
    private DataAgent dataAgent;
    private TopicsVO mTopicsVO;


    private TopicsModelImpl(){

        dataAgent = RetrofitDA.getObjInstance();

    }

    public static TopicsModelImpl getObjInstance(){
        if (objInstance == null)
        {
            objInstance = new TopicsModelImpl();
        }
                return objInstance;

    }

    @Override
    public void getTopics(String accessToken, int page, final TopicsDelegate topicsDelegate) {

        dataAgent.getTopics(accessToken, page, new TopicsResponseDelegate() {
            @Override
            public void onSuccess(List<TopicsVO> topicsVOList) {

                topicsDelegate.onSuccess(topicsVOList);

            }

            @Override
            public void onFail(String errormessage) {

                topicsDelegate.onFail(errormessage);
            }
        });
    }
}
