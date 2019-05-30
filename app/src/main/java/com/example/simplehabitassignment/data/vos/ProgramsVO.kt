package com.example.simplehabitassignment.data.vos

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

import com.google.gson.annotations.SerializedName

@Entity(tableName = "program")
class ProgramsVO {

    @PrimaryKey
    @SerializedName("program-id")
    var programId: String? = null

    @ColumnInfo(name = "name")
    @SerializedName("title")
    var title: String? = null

    @ColumnInfo(name = "name")
    @SerializedName("image")
    var image: String? = null

    @ColumnInfo(name = "name")
    @SerializedName("average-lengths")
    var averageLengths: List<Int>? = null

    @ColumnInfo(name = "name")
    @SerializedName("description")
    var description: String? = null

    @Embedded(prefix = "sess_")
    @SerializedName("sessions")
    var sessionsList: List<SessionsVO>? = null
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
