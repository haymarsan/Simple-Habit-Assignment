package com.example.simplehabitassignment.network.response


import com.example.simplehabitassignment.data.vos.LoginUserVO
import com.google.gson.annotations.SerializedName

class LoginResponse {

    @SerializedName("login_user")
    val loginUser: LoginUserVO? = null
}
