package com.example.simplehabitassignment.data.vos.models;

import android.content.Context;

import com.example.simplehabitassignment.network.DataAgent;
import com.example.simplehabitassignment.network.RetrofitDA;
import com.example.simplehabitassignment.persistence.dao.SimpleHabitDB;


public abstract class BaseModel {

    protected DataAgent mDataAgent;

    protected SimpleHabitDB mSimpleHabitDB;

    public BaseModel(Context context) {
        mDataAgent = RetrofitDA.getObjInstance();
        mSimpleHabitDB = SimpleHabitDB.getInstance(context);
    }
}
