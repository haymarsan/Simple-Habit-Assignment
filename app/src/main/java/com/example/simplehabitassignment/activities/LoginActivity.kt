package com.example.simplehabitassignment.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.EditText


import com.example.simplehabitassignment.R
import com.example.simplehabitassignment.data.vos.LoginUserVO
import com.example.simplehabitassignment.data.vos.models.UserModel
import com.example.simplehabitassignment.data.vos.models.UserModelImpl
import com.example.simplehabitassignment.delegates.LoginDelegate

import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick

class LoginActivity : BaseActivity() {

    @BindView(R.id.toolbar)
    internal var toolbar: Toolbar? = null

    @BindView(R.id.et_email_or_phone)
    internal var etEmailOrPhone: EditText? = null

    @BindView(R.id.et_password)
    internal var etPassword: EditText? = null

    private var mUserModel: UserModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        ButterKnife.bind(this)
        mUserModel = UserModelImpl.getInstance()

        setSupportActionBar(toolbar)
    }

    @OnClick(R.id.btn_login)
    fun onTapLogin(view: View) {
        val emailOrPhone = etEmailOrPhone!!.text.toString()
        val password = etPassword!!.text.toString()

        mUserModel!!.login(emailOrPhone, password, object : LoginDelegate {
            override fun onSuccess(loginUser: LoginUserVO) {
                val intent = MainActivity.newIntent(applicationContext)
                startActivity(intent)
            }

            override fun onFail(msg: String) {
                Snackbar.make(toolbar!!, msg, Snackbar.LENGTH_INDEFINITE).show()
            }
        })
    }

    companion object {


        fun newIntent(context: Context): Intent {

            return Intent(context, LoginActivity::class.java)
        }
    }
}
