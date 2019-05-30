package com.example.simplehabitassignment.data.vos

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "login_user")
class LoginUserVO {

    @PrimaryKey
    var userId: Int = 0

    @ColumnInfo(name = "name")
    var name: String? = null

    @ColumnInfo(name = "email")
    var email: String? = null

    @ColumnInfo(name = "phone_no")
    var phoneNo: String? = null

    @ColumnInfo(name = "profile_url")
    var profileUrl: String? = null

    @ColumnInfo(name = "cover_url")
    var coverUrl: String? = null
}

