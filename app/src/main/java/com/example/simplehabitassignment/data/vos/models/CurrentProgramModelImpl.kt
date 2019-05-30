package com.example.simplehabitassignment.data.vos.models


import com.example.simplehabitassignment.data.vos.CurrentProgramVO
import com.example.simplehabitassignment.delegates.CurrentProgramResponseDelegate
import com.example.simplehabitassignment.network.DataAgent
import com.example.simplehabitassignment.network.RetrofitDA

class CurrentProgramModelImpl private constructor() : CurrentProgramModel {
    private val dataAgent: DataAgent
    var mcurrentProgramVO: CurrentProgramVO? = null
        private set

    init {
        dataAgent = RetrofitDA.getObjInstance()
    }

    override fun getCurrentProgram(accessToken: String, page: Int, delegate: CurrentProgramModel.CurrentProgramDelegate) {

        dataAgent.getCurrentProgram(accessToken, page, object : CurrentProgramResponseDelegate {
            override fun onSuccess(currentProgram: CurrentProgramVO) {

                mcurrentProgramVO = currentProgram
                delegate.onSuccess(currentProgram)
            }

            override fun onFail(errorMessage: String) {
                delegate.onFail(errorMessage)
            }
        })


    }

    companion object {

        private var objInstance: CurrentProgramModelImpl? = null

        fun getObjInstance(): CurrentProgramModelImpl {
            if (objInstance == null) {
                objInstance = CurrentProgramModelImpl()
            }
            return objInstance
        }
    }
}
