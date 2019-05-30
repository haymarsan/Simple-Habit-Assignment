package com.example.simplehabitassignment.data.vos

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

import com.google.gson.annotations.SerializedName

@Entity(tableName = "current_program")
class CurrentProgramVO {

    @PrimaryKey
    var programId: String? = null

    @ColumnInfo(name = "title")
    @SerializedName("title")
    var title: String? = null

    @ColumnInfo(name = "current-period")
    @SerializedName("current-period")
    var currentPeriod: String? = null

    @ColumnInfo(name = "background")
    @SerializedName("background")
    var background: String? = null

    @ColumnInfo(name = "average-lengths")
    @SerializedName("average-lengths")
    var averageLengths: List<Int>? = null

    @ColumnInfo(name = "description")
    @SerializedName("description")
    var description: String? = null

    @Embedded(prefix = "sess_")
    @SerializedName("sessions")
    var sessionsList: List<SessionsVO>? = null
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
