package com.example.simplehabitassignment.persistence.dao

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.simplehabitassignment.data.vos.*

@Database(entities = [LoginUserVO::class, CurrentProgramVO::class, CategoriesAndProgramsVO::class,  ProgramsVO::class, TopicsVO::class], version = 1)
abstract class SimpleHabitDB : RoomDatabase() {
    abstract val loginDao: LoginUserDao
    abstract val categoriresAndProgramsDao: CategoriresAndProgramsDao
    abstract val

    companion object {

        private val DB_NAME = "news_database.DB"
        var simpleHabitDb: SimpleHabitDB? = null

        fun getInstance(context: Context): SimpleHabitDB {


            if (simpleHabitDb == null) {
                simpleHabitDb = Room.databaseBuilder(context, SimpleHabitDB::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .build()
            }

            return simpleHabitDb
        }
    }


    //    public boolean isNewsEmpty(){
    //
    //        NewsVO news = newsDao().getLatestNews();
    //        //return newsList == null || newsList.isEmpty();
    //        return news == null;
    //
    //    }

}
