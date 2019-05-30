package com.example.simplehabitassignment.data.vos

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.PrimaryKey

import com.google.gson.annotations.SerializedName


class SessionsVO {

    @ColumnInfo(name = "session-id")
    @SerializedName("session-id")
    var sessionId: String? = null

    @ColumnInfo(name = "title")
    @SerializedName("title")
    var title: String? = null

    @ColumnInfo(name = "length-in-seconds")
    @SerializedName("length-in-seconds")
    var lengthInSeconds: Int = 0

    @ColumnInfo(name = "file-path")
    @SerializedName("file-path")
    var filePath: String? = null
}


/*
"sessions":[{"session-id":"S0001",
        "title":"Fatigue and Drowsiness",
        "length-in-seconds":325,
        "file-path":"http:\/\/"}]},*/
