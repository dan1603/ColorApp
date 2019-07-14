package com.kalashnyk.denys.colorapp.di.module

import com.kalashnyk.denys.colorapp.di.scope.RepositoryScope
import com.kalashnyk.denys.colorapp.usecases.repository.AppRepository
import com.kalashnyk.denys.colorapp.usecases.repository.database.AppDatabase
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @RepositoryScope
    @Provides
    internal fun providesRepository(database: AppDatabase): AppRepository {
        return AppRepository(database)
    }
}