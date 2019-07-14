package com.kalashnyk.denys.colorapp.usecases.repository.database.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "colors")
data class ColorEntity(
    @PrimaryKey
    val color: String,
    val name: String
)


