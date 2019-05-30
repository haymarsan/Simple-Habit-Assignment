package com.example.simplehabitassignment.views.pods

import android.content.Context
import android.util.AttributeSet
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView

import com.example.simplehabitassignment.R

import butterknife.BindView

class LoginUserViewPod : RelativeLayout {


    @BindView(R.id.iv_login_user_bg)
    internal var ivLoginUserBg: ImageView? = null

    @BindView(R.id.iv_login_user)
    internal var ivLoginUser: ImageView? = null

    @BindView(R.id.tv_name)
    internal var tvName: TextView? = null

    @BindView(R.id.tv_phone_no)
    internal var tvPhoneNo: TextView? = null

    @BindView(R.id.btn_logout)
    internal var btnLogOut: Button? = null


    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}
}
