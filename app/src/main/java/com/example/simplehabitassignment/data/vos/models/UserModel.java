package com.example.simplehabitassignment.data.vos.models;


import com.example.simplehabitassignment.data.vos.LoginUserVO;
import com.example.simplehabitassignment.delegates.LoginDelegate;

public interface UserModel {

    void login(String emailOrPassword, String password, LoginDelegate loginDelegate);


    void onUserLogout();

    LoginUserVO getLoginUser();



    boolean isUserdLogin();
}
