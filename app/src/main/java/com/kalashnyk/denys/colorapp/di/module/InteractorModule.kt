package com.kalashnyk.denys.colorapp.di.module

import com.kalashnyk.denys.colorapp.di.scope.InteractorScope
import com.kalashnyk.denys.colorapp.usecases.Interactor
import com.kalashnyk.denys.colorapp.usecases.repository.AppRepository
import dagger.Module
import dagger.Provides

@Module
class InteractorModule {
    @InteractorScope
    @Provides
    internal fun providesInteractor(repository: AppRepository): Interactor {
        return Interactor(repository)
    }
}