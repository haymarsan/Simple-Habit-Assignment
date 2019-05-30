package com.example.simplehabitassignment.network

import android.util.Log

import com.example.simplehabitassignment.Utils.AppConstants
import com.example.simplehabitassignment.delegates.CategoriesAndProgramsResponseDelegate
import com.example.simplehabitassignment.delegates.CurrentProgramResponseDelegate
import com.example.simplehabitassignment.delegates.LoginDelegate
import com.example.simplehabitassignment.delegates.TopicsResponseDelegate
import com.example.simplehabitassignment.network.response.GetCategoriesAndProgramsResponse
import com.example.simplehabitassignment.network.response.GetCurrentProgramResponse
import com.example.simplehabitassignment.network.response.GetTopicsResponse
import com.example.simplehabitassignment.network.response.LoginResponse
import com.google.gson.Gson


import java.util.concurrent.TimeUnit

import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitDA private constructor() : DataAgent {
    private val mApi: SimpleHabitAPI


    init {
        val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build()


        val retrofit = Retrofit.Builder()
                .baseUrl(AppConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .client(okHttpClient)
                .build()

        mApi = retrofit.create(SimpleHabitAPI::class.java)


    }

    override fun getTopics(accessToken: String, page: Int, delegate: TopicsResponseDelegate) {


        val getTopicsResponseCall = mApi.getTopics(accessToken, page)

        getTopicsResponseCall.enqueue(object : Callback<GetTopicsResponse> {
            override fun onResponse(call: Call<GetTopicsResponse>, response: Response<GetTopicsResponse>) {
                val getTopicsResponse = response.body()

                if (getTopicsResponse!!.isResponseSuccessful) {
                    delegate.onSuccess(getTopicsResponse.topics!!)
                } else {
                    delegate.onFail(getTopicsResponse.message!!)
                }
            }

            override fun onFailure(call: Call<GetTopicsResponse>, t: Throwable) {

                delegate.onFail(t.message)
            }
        })


    }

    override fun getCurrentProgram(accessToken: String, page: Int, delegate: CurrentProgramResponseDelegate) {

        val getCurrentProgramResponseCall = mApi.getCurrentProgram(accessToken, page)
        getCurrentProgramResponseCall.enqueue(object : Callback<GetCurrentProgramResponse> {

            override fun onResponse(call: Call<GetCurrentProgramResponse>, response: Response<GetCurrentProgramResponse>) {
                val getCurrentProgramResponse = response.body()

                if (getCurrentProgramResponse!!.isResponseSuccessful) {
                    delegate.onSuccess(getCurrentProgramResponse.currentProgram!!)
                } else {
                    delegate.onFail(getCurrentProgramResponse.message!!)
                }
            }

            override fun onFailure(call: Call<GetCurrentProgramResponse>, t: Throwable) {

                delegate.onFail(t.message)

            }
        })
    }


    override fun getCategoriesAndPrograms(accessToken: String, page: Int, delegate: CategoriesAndProgramsResponseDelegate) {

        val getCategoriesAndProgramsResponseCall = mApi.getCategoriesAndPrograms(accessToken, page)

        getCategoriesAndProgramsResponseCall.enqueue(object : Callback<GetCategoriesAndProgramsResponse> {
            override fun onResponse(call: Call<GetCategoriesAndProgramsResponse>, response: Response<GetCategoriesAndProgramsResponse>) {

                val getCategoriesAndProgramsResponse = response.body()
                if (getCategoriesAndProgramsResponse!!.isResponseSuccessful) {
                    delegate.onSuccess(getCategoriesAndProgramsResponse.categoriesProgramsList!!)
                } else {
                    delegate.onFail(getCategoriesAndProgramsResponse.message!!)
                }


            }

            override fun onFailure(call: Call<GetCategoriesAndProgramsResponse>, t: Throwable) {

                delegate.onFail(t.message)
            }
        })
    }


    //    @Override
    //    public void login(String phoneNumber, String password, LoginDelegate loginDelegate) {
    //        Call<LoginResponse> callLoginResponse = mNewsAPI.login(phoneNumber, password);
    //        callLoginResponse.enqueue(new NewsCallback<LoginResponse, LoginDelegate>(loginDelegate) {
    //            @Override
    //            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
    //                super.onResponse(call, response);
    //                LoginResponse loginResponse = response.body();
    //                if (loginResponse != null && loginResponse.isResponseSuccess()) {
    //                    LoginUserVO loginUser = loginResponse.getLoginUser();
    //                    networkDelegate.onSuccess(loginUser);
    //                }
    //            }
    //        });
    //    }

    override fun login(phone: String, password: String, loginDelegate: LoginDelegate) {
        mApi.login(phone, password).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                loginDelegate.onSuccess(response.body()!!.loginUser!!)
                Log.d("Login", "Success")
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                loginDelegate.onFail("Network fail")
                Log.d("Login", "fail")

            }
        })
    }

    companion object {


        private var objInstance: RetrofitDA? = null

        fun getObjInstance(): RetrofitDA {

            if (objInstance == null) {
                objInstance = RetrofitDA()
            }

            return objInstance
        }
    }


}
