package com.example.simplehabitassignment.data.vos.models;

import android.content.Context;
import android.util.Log;

import com.example.simplehabitassignment.data.vos.LoginUserVO;
import com.example.simplehabitassignment.delegates.LoginDelegate;


public class UserModelImpl extends BaseModel implements UserModel {

    private static UserModel instance;



    private LoginUserVO mLoginUser;



    private UserModelImpl(Context context) {
//        mDataAgent = RetrofitDA.getInstance();
//        mNewsDB = NewsDatabase.getDatabase(context);

        super(context);
    }

    public static void initUserModel(Context context) {
        instance = new UserModelImpl(context);
    }


    public static UserModel getInstance() {
        if (instance == null) {
            throw new RuntimeException("USerModel should have been initialized before using it");
        }
        return instance;

    }

    @Override
    public void login(String emailOrPassword, String password, final LoginDelegate loginDelegate) {
        mDataAgent.login(emailOrPassword, password, new LoginDelegate() {
            @Override
            public void onSuccess(LoginUserVO loginUser) {
                mLoginUser = loginUser;
               long userID =  mSimpleHabitDB.getLoginDao().insertLoginUser(loginUser);
                Log.d("", "userID" + userID);
                loginDelegate.onSuccess(loginUser);
            }

            @Override
            public void onFail(String msg) {
                loginDelegate.onFail(msg);
            }
        });
    }

    @Override
    public void onUserLogout() {
        Log.d("Logout", "LogOut");
    }

//    @Override
//    public void onUserLogout() {
//        mSimpleHabitDB.getLoginDao().deleteLoginUser();
//    }


    @Override
    public LoginUserVO getLoginUser() {

        LoginUserVO loginUser =  mSimpleHabitDB.getLoginDao().getLoginUser();
        return loginUser;
    }

    @Override
    public boolean isUserdLogin() {
        return mSimpleHabitDB.getLoginDao().getLoginUser() != null;
    }
}
