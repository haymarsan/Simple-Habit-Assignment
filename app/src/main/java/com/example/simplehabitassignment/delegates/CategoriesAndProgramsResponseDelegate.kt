package com.example.simplehabitassignment.delegates


import com.example.simplehabitassignment.data.vos.CategoriesAndProgramsVO

interface CategoriesAndProgramsResponseDelegate : BaseDelegate {

    fun onSuccess(categoriesProgramsList: List<CategoriesAndProgramsVO>)

}
