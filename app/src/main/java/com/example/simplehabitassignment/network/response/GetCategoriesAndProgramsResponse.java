package com.example.simplehabitassignment.network.response;

import com.example.simplehabitassignment.data.vos.CategoriesAndProgramsVO;
import com.google.gson.annotations.SerializedName;


import java.util.List;

public class GetCategoriesAndProgramsResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("apiVersion")
    private String apiVersion;

    @SerializedName("page")
    private String page;

    @SerializedName("categoriesPrograms")
    private List<CategoriesAndProgramsVO> categoriesProgramsList;


    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getPage() {
        return page;
    }

    public List<CategoriesAndProgramsVO> getCategoriesProgramsList() {
        return categoriesProgramsList;
    }

    public boolean isResponseSuccessful()
    {
        return code==200;
    }
}
