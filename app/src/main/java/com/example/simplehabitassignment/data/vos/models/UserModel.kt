package com.example.simplehabitassignment.data.vos.models


import com.example.simplehabitassignment.data.vos.LoginUserVO
import com.example.simplehabitassignment.delegates.LoginDelegate

interface UserModel {

    val loginUser: LoginUserVO


    val isUserdLogin: Boolean

    fun login(emailOrPassword: String, password: String, loginDelegate: LoginDelegate)


    fun onUserLogout()
}
