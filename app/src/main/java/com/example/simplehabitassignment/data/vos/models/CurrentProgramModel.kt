package com.example.simplehabitassignment.data.vos.models


import com.example.simplehabitassignment.data.vos.CurrentProgramVO

interface CurrentProgramModel {

    fun getCurrentProgram(accessToken: String, page: Int, delegate: CurrentProgramDelegate)


    interface CurrentProgramDelegate {
        fun onSuccess(currentProgram: CurrentProgramVO)
        fun onFail(errorMessage: String)

    }
}
