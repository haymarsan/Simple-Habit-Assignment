package com.example.simplehabitassignment.network;

import android.util.Log;

import com.example.simplehabitassignment.Utils.AppConstants;
import com.example.simplehabitassignment.delegates.CategoriesAndProgramsResponseDelegate;
import com.example.simplehabitassignment.delegates.CurrentProgramResponseDelegate;
import com.example.simplehabitassignment.delegates.LoginDelegate;
import com.example.simplehabitassignment.delegates.TopicsResponseDelegate;
import com.example.simplehabitassignment.network.response.GetCategoriesAndProgramsResponse;
import com.example.simplehabitassignment.network.response.GetCurrentProgramResponse;
import com.example.simplehabitassignment.network.response.GetTopicsResponse;
import com.example.simplehabitassignment.network.response.LoginResponse;
import com.google.gson.Gson;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitDA implements DataAgent {


    private static RetrofitDA objInstance;
    private SimpleHabitAPI mApi;



    private RetrofitDA() {
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(okHttpClient)
                .build();

        mApi = retrofit.create(SimpleHabitAPI.class);


    }

    public static RetrofitDA getObjInstance() {

        if (objInstance == null) {
            objInstance = new RetrofitDA();
        }

        return objInstance;
    }

    @Override
    public void getTopics(String accessToken, int page, final TopicsResponseDelegate delegate) {


        Call<GetTopicsResponse> getTopicsResponseCall = mApi.getTopics(accessToken, page);

        getTopicsResponseCall.enqueue(new Callback<GetTopicsResponse>() {
            @Override
            public void onResponse(Call<GetTopicsResponse> call, Response<GetTopicsResponse> response) {
                GetTopicsResponse getTopicsResponse = response.body();

                if(getTopicsResponse.isResponseSuccessful())
                {
                    delegate.onSuccess(getTopicsResponse.getTopics());
                }
                else
                {
                    delegate.onFail(getTopicsResponse.getMessage());
                }
            }

            @Override
            public void onFailure(Call<GetTopicsResponse> call, Throwable t) {

                delegate.onFail(t.getMessage());
            }
        });


    }

    @Override
    public void getCurrentProgram(String accessToken, int page, final CurrentProgramResponseDelegate delegate) {

       Call<GetCurrentProgramResponse> getCurrentProgramResponseCall = mApi.getCurrentProgram(accessToken,page);
       getCurrentProgramResponseCall.enqueue(new Callback<GetCurrentProgramResponse>() {

           @Override
           public void onResponse(Call<GetCurrentProgramResponse> call, Response<GetCurrentProgramResponse> response) {
               GetCurrentProgramResponse getCurrentProgramResponse = response.body();

                   if(getCurrentProgramResponse.isResponseSuccessful())
                   {
                       delegate.onSuccess(getCurrentProgramResponse.getCurrentProgram());
                   }
                   else
                   {
                       delegate.onFail(getCurrentProgramResponse.getMessage());
                   }
           }

           @Override
           public void onFailure(Call<GetCurrentProgramResponse> call, Throwable t) {

               delegate.onFail(t.getMessage());

           }
       });
    }


    @Override
    public void getCategoriesAndPrograms(String accessToken, int page, final CategoriesAndProgramsResponseDelegate delegate) {

        final Call<GetCategoriesAndProgramsResponse> getCategoriesAndProgramsResponseCall = mApi.getCategoriesAndPrograms(accessToken, page);

        getCategoriesAndProgramsResponseCall.enqueue(new Callback<GetCategoriesAndProgramsResponse>() {
            @Override
            public void onResponse(Call<GetCategoriesAndProgramsResponse> call, Response<GetCategoriesAndProgramsResponse> response) {

                GetCategoriesAndProgramsResponse getCategoriesAndProgramsResponse = response.body();
               if(getCategoriesAndProgramsResponse.isResponseSuccessful())
                {
                        delegate.onSuccess(getCategoriesAndProgramsResponse.getCategoriesProgramsList());
                }
                else
               {
                   delegate.onFail(getCategoriesAndProgramsResponse.getMessage());
               }


            }

            @Override
            public void onFailure(Call<GetCategoriesAndProgramsResponse> call, Throwable t) {

                delegate.onFail(t.getMessage());
            }
        });
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

    @Override
    public void login(String phone, String password, final LoginDelegate loginDelegate) {
        mApi.login(phone,password).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                loginDelegate.onSuccess(response.body().getLoginUser());
                Log.d("Login","Success");
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                loginDelegate.onFail("Network fail");
                Log.d("Login","fail");

            }
        });
    }



}
