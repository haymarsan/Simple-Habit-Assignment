package com.example.simplehabitassignment.data.vos.models

import com.example.simplehabitassignment.data.vos.TopicsVO
import com.example.simplehabitassignment.delegates.TopicsResponseDelegate
import com.example.simplehabitassignment.network.DataAgent
import com.example.simplehabitassignment.network.RetrofitDA

class TopicsModelImpl private constructor() : TopicsModel {
    private val dataAgent: DataAgent
    private val mTopicsVO: TopicsVO? = null


    init {

        dataAgent = RetrofitDA.getObjInstance()

    }

    override fun getTopics(accessToken: String, page: Int, topicsDelegate: TopicsModel.TopicsDelegate) {

        dataAgent.getTopics(accessToken, page, object : TopicsResponseDelegate {
            override fun onSuccess(topicsVOList: List<TopicsVO>) {

                topicsDelegate.onSuccess(topicsVOList)

            }

            override fun onFail(errormessage: String) {

                topicsDelegate.onFail(errormessage)
            }
        })
    }

    companion object {

        private var objInstance: TopicsModelImpl? = null

        fun getObjInstance(): TopicsModelImpl {
            if (objInstance == null) {
                objInstance = TopicsModelImpl()
            }
            return objInstance

        }
    }
}
