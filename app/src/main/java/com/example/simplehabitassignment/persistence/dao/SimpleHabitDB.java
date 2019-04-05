package com.example.simplehabitassignment.persistence.dao;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.simplehabitassignment.data.vos.LoginUserVO;

@Database(entities = LoginUserVO.class, version = 1)
public abstract class SimpleHabitDB extends RoomDatabase {

    private static final String DB_NAME = "news_database.DB";
    public static SimpleHabitDB simpleHabitDb;

    public SimpleHabitDB() {
    }

    public static SimpleHabitDB getInstance(Context context) {


        if (simpleHabitDb == null) {
            simpleHabitDb = Room.databaseBuilder(context, SimpleHabitDB.class, DB_NAME)
                    .allowMainThreadQueries()
                    .build();
        }

        return simpleHabitDb;
    }
    public abstract LoginUserDao getLoginDao();


//    public boolean isNewsEmpty(){
//
//        NewsVO news = newsDao().getLatestNews();
//        //return newsList == null || newsList.isEmpty();
//        return news == null;
//
//    }

}
