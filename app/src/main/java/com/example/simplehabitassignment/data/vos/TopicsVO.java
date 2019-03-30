package com.example.simplehabitassignment.data.vos;

import com.google.gson.annotations.SerializedName;

public class TopicsVO {

    @SerializedName("topic-name")
    private String topicName;

    @SerializedName("topic-desc")
    private String topicDesc;

    @SerializedName("icon")
    private String icon;

    @SerializedName("background")
    private String background;


    public String getTopicName() {
        return topicName;
    }

    public String getTopicDesc() {
        return topicDesc;
    }

    public String getIcon() {
        return icon;
    }

    public String getBackground() {
        return background;
    }
}



/*
{"code":200,"message":"success",
        "apiVersion":"v1",
        "page":"1",
        "topics":
        [{"topic-name":"Basics",
        "topic-desc":"Learn meditation fundamentals",
        "icon":"http:\/\/",
        "background":"http:\/\/"},
        {"topic-name":"Relax",
        "topic-desc":"Unwind and relieve stress",
        "icon":"http:\/\/",
        "background":"http:\/\/"}]}*/
