package com.example.simplehabitassignment.mvp.view

import com.example.simplehabitassignment.data.vos.SessionsVO

interface DetailsView : BaseView{

    //TODO Details
    fun showDetailsData(sessionsList: MutableList<SessionsVO>)

}