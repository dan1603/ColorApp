package com.kalashnyk.denys.colorapp.usecases.repository.database.dao

import android.arch.persistence.room.*
import com.kalashnyk.denys.colorapp.usecases.repository.database.entity.ColorEntity

@Dao
interface ColorDao {
    @Query("SELECT * FROM colors")
    fun getAll(): List<ColorEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertList(list: List<ColorEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun update(colorEntity: ColorEntity)

    @Update
    fun updateAll(list: List<ColorEntity>)

    @Delete
    fun delete(colorEntity: ColorEntity)
}