package com.dezdeqness.data.datasource.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dezdeqness.data.model.db.GenreLocal

@Dao
interface GenreDao {

    @Query("SELECT * FROM 'genre'")
    fun getGenres(): List<GenreLocal>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveGenres(list: List<GenreLocal>)

    @Query("DELETE FROM 'genre'")
    fun clear()

}
