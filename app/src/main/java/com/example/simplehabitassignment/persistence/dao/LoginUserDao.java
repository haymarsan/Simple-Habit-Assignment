package com.example.simplehabitassignment.persistence.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.simplehabitassignment.data.vos.LoginUserVO;

@Dao
public interface LoginUserDao {

    @Insert
    long insertLoginUser(LoginUserVO loginUserVO);

    @Query("SELECT * FROM login_user")
    LoginUserVO getLoginUser();

    @Delete
    void delete(LoginUserVO loginUserVO);
}
