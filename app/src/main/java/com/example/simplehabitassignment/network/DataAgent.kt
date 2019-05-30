package com.example.simplehabitassignment.network


import com.example.simplehabitassignment.delegates.CategoriesAndProgramsResponseDelegate
import com.example.simplehabitassignment.delegates.CurrentProgramResponseDelegate
import com.example.simplehabitassignment.delegates.LoginDelegate
import com.example.simplehabitassignment.delegates.TopicsResponseDelegate

interface DataAgent {


    fun getTopics(accessToken: String, page: Int, delegate: TopicsResponseDelegate)
    fun getCategoriesAndPrograms(accessToken: String, page: Int, delegate: CategoriesAndProgramsResponseDelegate)
    fun getCurrentProgram(accessToken: String, page: Int, delegate: CurrentProgramResponseDelegate)
    fun login(phone: String, password: String, loginDelegate: LoginDelegate)
}
