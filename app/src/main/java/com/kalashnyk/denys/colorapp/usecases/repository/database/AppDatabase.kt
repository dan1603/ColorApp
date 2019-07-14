package com.kalashnyk.denys.colorapp.usecases.repository.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.kalashnyk.denys.colorapp.usecases.repository.database.dao.ColorDao
import com.kalashnyk.denys.colorapp.usecases.repository.database.entity.ColorEntity

@Database(entities = [(ColorEntity::class)], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun colorDao(): ColorDao
}