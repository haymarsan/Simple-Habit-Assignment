package com.example.simplehabitassignment.delegates;


import com.example.simplehabitassignment.data.vos.CurrentProgramVO;

public interface CurrentProgramResponseDelegate {

    void onSuccess(CurrentProgramVO currentProgram);

    void onFail(String errorMessage);
}
