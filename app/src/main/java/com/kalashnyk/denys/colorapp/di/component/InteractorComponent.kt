package com.kalashnyk.denys.colorapp.di.component

import com.kalashnyk.denys.colorapp.di.module.InteractorModule
import com.kalashnyk.denys.colorapp.di.scope.InteractorScope
import com.kalashnyk.denys.colorapp.usecases.Interactor
import dagger.Component

@InteractorScope
@Component(modules = [InteractorModule::class], dependencies = [RepositoryComponent::class])
interface InteractorComponent {
    val interactor: Interactor
}