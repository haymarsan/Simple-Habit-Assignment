package com.example.simplehabitassignment.data.vos.models

import com.example.simplehabitassignment.data.vos.TopicsVO

interface TopicsModel {

    fun getTopics(accessToken: String, page: Int, topicsDelegate: TopicsDelegate)


    interface TopicsDelegate {
        fun onSuccess(topicsVO: List<TopicsVO>)
        fun onFail(errorMessage: String)

    }


}
