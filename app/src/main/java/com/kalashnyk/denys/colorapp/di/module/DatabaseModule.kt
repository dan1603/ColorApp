package com.kalashnyk.denys.colorapp.di.module

import com.kalashnyk.denys.colorapp.usecases.repository.database.AppDatabase
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule(private val appDatabase: AppDatabase) {
    @Provides
    internal fun providesRoomDatabase(): AppDatabase {
        return appDatabase
    }
}