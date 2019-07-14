package com.kalashnyk.denys.colorapp.di.component

import com.kalashnyk.denys.colorapp.di.module.RepositoryModule
import com.kalashnyk.denys.colorapp.di.scope.RepositoryScope
import com.kalashnyk.denys.colorapp.usecases.repository.AppRepository
import dagger.Component

@RepositoryScope
@Component(modules = [RepositoryModule::class], dependencies = [DatabaseComponent::class])
interface RepositoryComponent {
    val repository: AppRepository
}