package com.example.simplehabitassignment.delegates


import com.example.simplehabitassignment.data.vos.CurrentProgramVO

interface CurrentProgramResponseDelegate : BaseDelegate {

    fun onSuccess(currentProgram: CurrentProgramVO)

}
