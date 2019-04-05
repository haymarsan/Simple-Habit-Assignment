package com.example.simplehabitassignment.network.response;


import com.example.simplehabitassignment.data.vos.LoginUserVO;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("login_user")
    private LoginUserVO loginUser;

    public LoginUserVO getLoginUser() {
        return loginUser;
    }
}
