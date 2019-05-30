package com.example.simplehabitassignment.persistence.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.simplehabitassignment.data.vos.TopicsVO

@Dao
abstract class TopicsDao {

    @Query("SELECT * FROM topics")
    abstract fun getAllTopics(): MutableList<TopicsVO>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun insertAllTopics(topicsVO: MutableList<TopicsVO>): List<Long>

}