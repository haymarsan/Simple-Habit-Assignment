package com.example.simplehabitassignment.data.vos.models


import com.example.simplehabitassignment.data.vos.CategoriesAndProgramsVO
import com.example.simplehabitassignment.data.vos.ProgramsVO
import com.example.simplehabitassignment.delegates.CategoriesAndProgramsResponseDelegate
import com.example.simplehabitassignment.network.DataAgent
import com.example.simplehabitassignment.network.RetrofitDA

import java.util.HashMap

class CategoriesAndProgramsModelImpl private constructor() : CategoriesAndProgramsModel {
    private val dataAgent: DataAgent
    private val programsMap: MutableMap<String, ProgramsVO>

    init {
        dataAgent = RetrofitDA.getObjInstance()
        programsMap = HashMap()
    }

    override fun getCategoriesAndPrograms(accessToken: String, page: Int, delegate: CategoriesAndProgramsModel.CategoriesAndProgramsDelegate) {

        dataAgent.getCategoriesAndPrograms(accessToken, page, object : CategoriesAndProgramsResponseDelegate {
            override fun onSuccess(categoriesProgramsList: List<CategoriesAndProgramsVO>) {
                setProgramsMap(categoriesProgramsList)
                delegate.onSuccess(categoriesProgramsList)
            }

            override fun onFail(errorMessage: String) {

                delegate.onFail(errorMessage)

            }
        })


    }

    private fun setProgramsMap(categoriesProgramsList: List<CategoriesAndProgramsVO>) {


        for (c in categoriesProgramsList) {

            for (p in c.programsList) {

                programsMap[p.programId] = p


            }
        }


    }


    fun getProgramById(programId: String): ProgramsVO? {
        return programsMap[programId]
    }

    companion object {

        private var objInstance: CategoriesAndProgramsModelImpl? = null

        fun getObjInstance(): CategoriesAndProgramsModelImpl {
            if (objInstance == null) {
                objInstance = CategoriesAndProgramsModelImpl()
            }
            return objInstance
        }
    }

}
