package com.example.simplehabitassignment.persistence.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.simplehabitassignment.data.vos.ProgramsVO

@Dao
abstract class ProgramDao {

    @Query("SELECT * FROM program")
    abstract fun getProgram(): MutableList<ProgramsVO>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun insertGetProgram(programsVO: MutableList<ProgramsVO>) : List<Long>


    

}