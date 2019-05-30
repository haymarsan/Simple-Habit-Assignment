package com.example.simplehabitassignment.data.vos.models


import com.example.simplehabitassignment.data.vos.CategoriesAndProgramsVO

interface CategoriesAndProgramsModel {


    fun getCategoriesAndPrograms(accessToken: String, page: Int, delegate: CategoriesAndProgramsDelegate)

    interface CategoriesAndProgramsDelegate {
        fun onSuccess(categoriesProgramsList: List<CategoriesAndProgramsVO>)

        fun onFail(errorMessage: String)


    }
}
