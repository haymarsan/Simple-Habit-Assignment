package com.example.simplehabitassignment.persistence.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.simplehabitassignment.data.vos.CategoriesAndProgramsVO

@Dao
abstract class CategoriresAndProgramsDao {
    @Query("SELECT * FROM categories_programs")
    abstract fun getCategoryAndProgram(): MutableList<CategoriesAndProgramsVO>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun insertCategorAndProgram(categoriesAndPrograms: MutableList<CategoriesAndProgramsVO>): List<Long>
}