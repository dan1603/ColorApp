package com.kalashnyk.denys.colorapp.di.component

import com.kalashnyk.denys.colorapp.di.module.ViewModelModule
import com.kalashnyk.denys.colorapp.di.scope.ViewModelScope
import com.kalashnyk.denys.colorapp.presentation.activities.main.MainActivity
import com.kalashnyk.denys.colorapp.presentation.activities.splash.SplashActivity
import dagger.Component

@ViewModelScope
@Component(modules = [ViewModelModule::class], dependencies = [InteractorComponent::class])
interface ViewModelComponent {
    fun inject(activity: MainActivity)
}