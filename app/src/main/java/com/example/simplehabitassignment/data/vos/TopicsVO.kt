package com.example.simplehabitassignment.data.vos

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

import com.google.gson.annotations.SerializedName

@Entity(tableName = "topics")
class TopicsVO {

    @PrimaryKey
    @SerializedName("topic-name")
    var topicName: String? = null

    @ColumnInfo(name = "topic-desc")
    @SerializedName("topic-desc")
    var topicDesc: String? = null

    @ColumnInfo(name = "icon")
    @SerializedName("icon")
    var icon: String? = null

    @ColumnInfo(name = "background")
    @SerializedName("background")
    var background: String? = null
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
