package com.example.simplehabitassignment.delegates;


import com.example.simplehabitassignment.data.vos.CurrentProgramVO;

public interface CurrentProgramResponseDelegate extends BaseDelegate{

    void onSuccess(CurrentProgramVO currentProgram);

}
