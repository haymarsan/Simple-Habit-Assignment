package com.example.simplehabitassignment.network


import com.example.simplehabitassignment.Utils.AppConstants
import com.example.simplehabitassignment.network.response.GetCategoriesAndProgramsResponse
import com.example.simplehabitassignment.network.response.GetCurrentProgramResponse
import com.example.simplehabitassignment.network.response.GetTopicsResponse
import com.example.simplehabitassignment.network.response.LoginResponse

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface SimpleHabitAPI {

    @FormUrlEncoded
    @POST("getTopics.php")
    fun getTopics(@Field("access_token") accessToken: String, @Field("page") page: Int): Call<GetTopicsResponse>

    @FormUrlEncoded
    @POST("getCurrentProgram.php")
    fun getCurrentProgram(@Field("access_token") accessToken: String, @Field("page") page: Int): Call<GetCurrentProgramResponse>

    @FormUrlEncoded
    @POST("getCategoriesPrograms.php")
    fun getCategoriesAndPrograms(@Field("access_token") accessToken: String, @Field("page") page: Int): Call<GetCategoriesAndProgramsResponse>


    @FormUrlEncoded
    @POST(AppConstants.LOGIN_URL)
    fun login(@Field("phoneNo") phoneNo: String,
              @Field("password") password: String): Call<LoginResponse>


}
