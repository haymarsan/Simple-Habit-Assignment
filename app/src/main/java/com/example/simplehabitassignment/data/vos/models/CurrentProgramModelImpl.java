package com.example.simplehabitassignment.data.vos.models;


import com.example.simplehabitassignment.data.vos.CurrentProgramVO;
import com.example.simplehabitassignment.delegates.CurrentProgramResponseDelegate;
import com.example.simplehabitassignment.network.DataAgent;
import com.example.simplehabitassignment.network.RetrofitDA;

public class CurrentProgramModelImpl implements CurrentProgramModel {

    private static  CurrentProgramModelImpl objInstance;
    private DataAgent dataAgent;
    private CurrentProgramVO mcurrentProgramVO;

    private CurrentProgramModelImpl() {
        dataAgent = RetrofitDA.getObjInstance();
    }

    public static CurrentProgramModelImpl getObjInstance() {
        if(objInstance == null)
        {
            objInstance = new CurrentProgramModelImpl();
        }
        return objInstance;
    }

    @Override
    public void getCurrentProgram(String accessToken, int page, final CurrentProgramDelegate delegate) {

        dataAgent.getCurrentProgram(accessToken, page, new CurrentProgramResponseDelegate() {
            @Override
            public void onSuccess(CurrentProgramVO currentProgram) {

                mcurrentProgramVO = currentProgram;
                delegate.onSuccess(currentProgram);
            }

            @Override
            public void onFail(String errorMessage) {
                delegate.onFail(errorMessage);
            }
        });




    }


    public CurrentProgramVO getMcurrentProgramVO() {
        return mcurrentProgramVO;
    }
}
