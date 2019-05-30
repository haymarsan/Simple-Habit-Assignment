package com.example.simplehabitassignment.data.vos.models

import android.content.Context
import android.util.Log

import com.example.simplehabitassignment.data.vos.LoginUserVO
import com.example.simplehabitassignment.delegates.LoginDelegate


class UserModelImpl private constructor(context: Context)//        mDataAgent = RetrofitDA.getInstance();
//        mNewsDB = NewsDatabase.getDatabase(context);
    : BaseModel(context), UserModel {


    private var mLoginUser: LoginUserVO? = null

    //    @Override
    //    public void onUserLogout() {
    //        mSimpleHabitDB.getLoginDao().deleteLoginUser();
    //    }


    override val loginUser: LoginUserVO
        get() = mSimpleHabitDB.loginDao.loginUser

    override val isUserdLogin: Boolean
        get() = mSimpleHabitDB.loginDao.loginUser != null

    override fun login(emailOrPassword: String, password: String, loginDelegate: LoginDelegate) {
        mDataAgent.login(emailOrPassword, password, object : LoginDelegate {
            override fun onSuccess(loginUser: LoginUserVO) {
                mLoginUser = loginUser
                val userID = mSimpleHabitDB.loginDao.insertLoginUser(loginUser)
                Log.d("", "userID$userID")
                loginDelegate.onSuccess(loginUser)
            }

            override fun onFail(msg: String) {
                loginDelegate.onFail(msg)
            }
        })
    }

    override fun onUserLogout() {
        Log.d("Logout", "LogOut")
    }

    companion object {

        private var instance: UserModel? = null

        fun initUserModel(context: Context) {
            instance = UserModelImpl(context)
        }


        fun getInstance(): UserModel {
            if (instance == null) {
                throw RuntimeException("USerModel should have been initialized before using it")
            }
            return instance

        }
    }
}
