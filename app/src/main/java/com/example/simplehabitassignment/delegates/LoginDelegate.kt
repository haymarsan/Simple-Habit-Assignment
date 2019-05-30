package com.example.simplehabitassignment.delegates


import com.example.simplehabitassignment.data.vos.LoginUserVO

interface LoginDelegate : BaseDelegate {

    fun onSuccess(loginUser: LoginUserVO)
}
