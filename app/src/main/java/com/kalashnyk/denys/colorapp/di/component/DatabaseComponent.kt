package com.kalashnyk.denys.colorapp.di.component

import com.kalashnyk.denys.colorapp.di.module.DatabaseModule
import com.kalashnyk.denys.colorapp.usecases.repository.database.AppDatabase
import dagger.Component

@Component(modules = [DatabaseModule::class])
interface DatabaseComponent {
    val database: AppDatabase
}
