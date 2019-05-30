package com.example.simplehabitassignment.persistence.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

import com.example.simplehabitassignment.data.vos.LoginUserVO

@Dao
interface LoginUserDao {

    @get:Query("SELECT * FROM login_user")
    val loginUser: LoginUserVO

    @Insert
    fun insertLoginUser(loginUserVO: LoginUserVO): Long

    @Delete
    fun delete(loginUserVO: LoginUserVO)
}
