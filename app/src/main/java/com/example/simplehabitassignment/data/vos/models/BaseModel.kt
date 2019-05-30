package com.example.simplehabitassignment.data.vos.models

import android.content.Context

import com.example.simplehabitassignment.network.DataAgent
import com.example.simplehabitassignment.network.RetrofitDA
import com.example.simplehabitassignment.persistence.dao.SimpleHabitDB


abstract class BaseModel(context: Context) {

    protected var mDataAgent: DataAgent

    protected var mSimpleHabitDB: SimpleHabitDB

    init {
        mDataAgent = RetrofitDA.getObjInstance()
        mSimpleHabitDB = SimpleHabitDB.getInstance(context)
    }
}
