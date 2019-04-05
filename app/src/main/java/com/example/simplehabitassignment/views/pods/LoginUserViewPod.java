package com.example.simplehabitassignment.views.pods;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.simplehabitassignment.R;

import butterknife.BindView;

public class LoginUserViewPod extends RelativeLayout {


    @BindView(R.id.iv_login_user_bg)
    ImageView ivLoginUserBg;

    @BindView(R.id.iv_login_user)
    ImageView ivLoginUser;

    @BindView(R.id.tv_name)
    TextView tvName;

    @BindView(R.id.tv_phone_no)
    TextView tvPhoneNo;

    @BindView(R.id.btn_logout)
    Button btnLogOut;





    public LoginUserViewPod(Context context) {
        super(context);
    }

    public LoginUserViewPod(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LoginUserViewPod(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
