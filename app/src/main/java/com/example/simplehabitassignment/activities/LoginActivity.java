package com.example.simplehabitassignment.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;


import com.example.simplehabitassignment.R;
import com.example.simplehabitassignment.data.vos.LoginUserVO;
import com.example.simplehabitassignment.data.vos.models.UserModel;
import com.example.simplehabitassignment.data.vos.models.UserModelImpl;
import com.example.simplehabitassignment.delegates.LoginDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.et_email_or_phone)
    EditText etEmailOrPhone;

    @BindView(R.id.et_password)
    EditText etPassword;

    private UserModel mUserModel;



    public static Intent newIntent (Context context){

        Intent intent = new Intent( context, LoginActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mUserModel = UserModelImpl.getInstance();

        setSupportActionBar(toolbar);
    }

    @OnClick(R.id.btn_login)
    public void onTapLogin(View view) {
        String emailOrPhone = etEmailOrPhone.getText().toString();
        String password = etPassword.getText().toString();

        mUserModel.login(emailOrPhone, password, new LoginDelegate() {
            @Override
            public void onSuccess(LoginUserVO loginUser) {
                Intent intent = MainActivity.newIntent(getApplicationContext());
                startActivity(intent);
            }

            @Override
            public void onFail(String msg) {
                Snackbar.make(toolbar, msg, Snackbar.LENGTH_INDEFINITE).show();
            }
        });
    }
}
