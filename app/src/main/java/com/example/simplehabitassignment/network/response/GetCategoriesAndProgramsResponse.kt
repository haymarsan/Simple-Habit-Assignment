package com.example.simplehabitassignment.network.response

import com.example.simplehabitassignment.data.vos.CategoriesAndProgramsVO
import com.google.gson.annotations.SerializedName

class GetCategoriesAndProgramsResponse {

    @SerializedName("code")
    val code: Int = 0

    @SerializedName("message")
    val message: String? = null

    @SerializedName("apiVersion")
    val apiVersion: String? = null

    @SerializedName("page")
    val page: String? = null

    @SerializedName("categoriesPrograms")
    val categoriesProgramsList: List<CategoriesAndProgramsVO>? = null

    val isResponseSuccessful: Boolean
        get() = code == 200
}
