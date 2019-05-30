package com.example.simplehabitassignment.data.vos

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

import com.google.gson.annotations.SerializedName

@Entity(tableName = "categories_programs")
class CategoriesAndProgramsVO {


    @PrimaryKey
    @SerializedName("category-id")
    var categoryId: String? = null

    @ColumnInfo(name = "title")
    @SerializedName("title")
    var title: String? = null

    @Embedded(prefix = "prog_")
    @SerializedName("programs")
    var programsList: List<ProgramsVO>? = null

    @ColumnInfo(name = "image")
    @SerializedName("image")
    var image: String? = null

    @ColumnInfo(name = "average_lengths")
    @SerializedName("average-lengths")
    var averageLengths: String? = null

    @ColumnInfo(name = "description")
    @SerializedName("description")
    var description: String? = null
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
