package com.example.simplehabitassignment.network.response

import com.example.simplehabitassignment.data.vos.CurrentProgramVO
import com.google.gson.annotations.SerializedName


class GetCurrentProgramResponse {

    @SerializedName("code")
    val code: Int = 0

    @SerializedName("message")
    val message: String? = null

    @SerializedName("apiVersion")
    val apiVersion: String? = null

    @SerializedName("currentProgram")
    val currentProgram: CurrentProgramVO? = null

    val isResponseSuccessful: Boolean
        get() = code == 200
}
