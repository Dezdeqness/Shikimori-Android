package com.dezdeqness.data.model.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dezdeqness.data.core.DataModel

@Entity(tableName = "genre")
data class GenreLocal(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val genreId: Int,
    val name: String,
    val russian: String,
    val type: String,
) : DataModel.Db
