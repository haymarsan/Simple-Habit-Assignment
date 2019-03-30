package com.example.simplehabitassignment.data.vos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CurrentProgramVO {

    private String programId;

    @SerializedName("title")
    private String title;

    @SerializedName("current-period")
    private String currentPeriod;

    @SerializedName("background")
    private String background;

    @SerializedName("average-lengths")
    private List<Integer> averageLengths;

    @SerializedName("description")
    private String description;

    @SerializedName("sessions")
    private List <SessionsVO> sessionsList;


    public String getProgramId() {
        return programId;
    }

    public String getTitle() {
        return title;
    }

    public String getCurrentPeriod() {
        return currentPeriod;
    }

    public String getBackground() {
        return background;
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
{"code":200,"message":"success","apiVersion":"v1","currentProgram":{"program-id":"P001234",
        "title":"Simple Habit Starter",
        "current-period":"Day 2",
        "background":"http:\/\/",
        "average-lengths":[5],
        "description":"This is our signature 7 day introductory course to mindfulness meditation.",
        "sessions":[{"session-id":"S2710","title":"Introducing mindfulness","length-in-seconds":333,
        "file-path":"http:\/\/"}]}}*/
