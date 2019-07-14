package com.kalashnyk.denys.colorapp.usecases

import android.content.Context
import com.kalashnyk.denys.colorapp.usecases.repository.AppRepository
import com.kalashnyk.denys.colorapp.usecases.repository.database.entity.ColorEntity
import io.reactivex.Single

class Interactor(private val repository: AppRepository) {

    fun getAll(context: Context): Single<List<ColorEntity>>? {
        return repository.getAll(context)
    }

}