package com.example.simplehabitassignment.network.response;

import com.example.simplehabitassignment.data.vos.CurrentProgramVO;
import com.google.gson.annotations.SerializedName;


public class GetCurrentProgramResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("apiVersion")
    private String apiVersion;

    @SerializedName("currentProgram")
    private CurrentProgramVO currentProgram;


    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public CurrentProgramVO getCurrentProgram() {
        return currentProgram;
    }

    public  boolean isResponseSuccessful()
    {
        return  code == 200;
    }
}
