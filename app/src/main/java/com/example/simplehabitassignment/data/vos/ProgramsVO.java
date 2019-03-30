package com.example.simplehabitassignment.data.vos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProgramsVO {

    @SerializedName("program-id")
    private String programId;

    @SerializedName("title")
    private String title;

    @SerializedName("image")
    private String image;

    @SerializedName("average-lengths")
    private List<Integer> averageLengths;

    @SerializedName("description")
    private String description;

    @SerializedName("sessions")
    private List<SessionsVO> sessionsList;


    public String getProgramId() {
        return programId;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public List<Integer> getAverageLengths() {
        return averageLengths;
    }

    public String getDescription() {
        return description;
    }

    public List<SessionsVO> getSessionsList() {
        return sessionsList;
    }
}


/*
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
        "description":"Quuick 5 minute meditation after work, when you just got home.",*/
