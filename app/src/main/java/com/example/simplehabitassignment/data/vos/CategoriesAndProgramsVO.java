package com.example.simplehabitassignment.data.vos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoriesAndProgramsVO {


    @SerializedName("category-id")
    private String categoryId;

    @SerializedName("title")
    private String title;

    @SerializedName("programs")
    private List<ProgramsVO> programsList;

    @SerializedName("image")
    private String image;

    @SerializedName("average-lengths")
    private String averageLengths;

    @SerializedName("description")
    private String description;


    public String getCategoryId() {
        return categoryId;
    }

    public String getTitle() {
        return title;
    }

    public List<ProgramsVO> getProgramsList() {
        return programsList;
    }

    public String getImage() {
        return image;
    }

    public String getAverageLengths() {
        return averageLengths;
    }

    public String getDescription() {
        return description;
    }
}



/*{"code":200,"message":"success","apiVersion":"v1","page":"1","categoriesPrograms":[{"category-id":"A001",
        "title":"Evening Meditations",
        "programs":[{"program-id":"P0026",
        "title":"Feeling Tired",
        "image":"http:\/\/",
        "average-lengths":[5],
        "description":"This 5-minute meditation will help you through feelings of fatigue and drowsiness",
        "sessions":[{"session-id":"S0001",
        "title":"Fatigue and Drowsiness",
        "length-in-seconds":325,"file-path":
        "http:\/\/"}]},{"program-id":"P0213",
        "title":"Just Got Home",
        "image":"http:\/\/",
        "average-lengths":[5],
        "description":"Quuick 5 minute meditation after work, when you just got home.",
        "sessions":[{"session-id":"S0106",
        "title":"Unwind after Work",
        "length-in-seconds":326,
        "file-path":"http:\/\/"}]}]},
        {"category-id":"A0245",
        "title":"A Healthy Mind",*/
