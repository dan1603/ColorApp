package com.kalashnyk.denys.colorapp.di.module

import android.app.Application
import com.kalashnyk.denys.colorapp.App
import com.kalashnyk.denys.colorapp.di.scope.ViewModelScope
import com.kalashnyk.denys.colorapp.domain.ColorsViewModel
import com.kalashnyk.denys.colorapp.usecases.Interactor
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule(app: App) {

    internal var app: Application = app

    @ViewModelScope
    @Provides
    internal fun providesColorsViewModel(interactor: Interactor): ColorsViewModel {
        return ColorsViewModel(app, interactor)
    }

}