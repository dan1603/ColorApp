package com.kalashnyk.denys.colorapp.usecases.repository

import android.content.Context
import com.kalashnyk.denys.colorapp.usecases.repository.database.AppDatabase
import com.kalashnyk.denys.colorapp.usecases.repository.database.entity.ColorEntity
import com.kalashnyk.denys.colorapp.utils.XmlParser
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*

class AppRepository(private val mainDatabase: AppDatabase) {

    fun getAll(context: Context): Single<List<ColorEntity>>? {
        return XmlParser.parseColors(context)?.flatMap { list ->
            mainDatabase.colorDao().insertList(Objects.requireNonNull(list))
            Single.just(mainDatabase.colorDao().getAll())
        }
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
    }

}