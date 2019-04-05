package com.example.simplehabitassignment.delegates;


import com.example.simplehabitassignment.data.vos.LoginUserVO;

public interface LoginDelegate extends BaseDelegate {

    void onSuccess(LoginUserVO loginUser);
}
