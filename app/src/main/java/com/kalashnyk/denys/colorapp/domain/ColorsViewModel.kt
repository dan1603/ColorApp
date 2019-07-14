package com.kalashnyk.denys.colorapp.domain

import android.annotation.SuppressLint
import android.app.Application
import android.arch.lifecycle.LiveData
import com.kalashnyk.denys.colorapp.presentation.widget.SingleLiveEvent
import com.kalashnyk.denys.colorapp.usecases.Interactor
import com.kalashnyk.denys.colorapp.usecases.repository.database.entity.ColorEntity

class ColorsViewModel(application: Application, private val interactor: Interactor) : BaseViewModel(application) {
    private val liveDataItems = SingleLiveEvent<List<ColorEntity>>()

    @SuppressLint("CheckResult")
    fun getAllItems() {
        interactor.getAll(getApplication())?.subscribe { list -> liveDataItems.value = list }
    }

    fun getLiveDataItems(): LiveData<List<ColorEntity>> {
        return liveDataItems
    }
}

