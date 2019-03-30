package com.example.simplehabitassignment.data.vos;

import com.google.gson.annotations.SerializedName;

public class SessionsVO {

    @SerializedName("session-id")
    private String sessionId;

    @SerializedName("title")
    private String title;

    @SerializedName("length-in-seconds")
    private int lengthInSeconds;

    @SerializedName("file-path")
    private  String filePath;


    public String getSessionId() {
        return sessionId;
    }

    public String getTitle() {
        return title;
    }

    public int getLengthInSeconds() {
        return lengthInSeconds;
    }

    public String getFilePath() {
        return filePath;
    }
}


/*
"sessions":[{"session-id":"S0001",
        "title":"Fatigue and Drowsiness",
        "length-in-seconds":325,
        "file-path":"http:\/\/"}]},*/
