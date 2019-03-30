package com.example.simplehabitassignment.data.vos.models;


import com.example.simplehabitassignment.data.vos.CurrentProgramVO;

public interface CurrentProgramModel {

    void getCurrentProgram(String accessToken, int page, CurrentProgramDelegate delegate);


    interface  CurrentProgramDelegate
    {
        void onSuccess(CurrentProgramVO currentProgram);
        void onFail(String errorMessage);

    }
}
