package com.dezdeqness.data.datasource.db

import com.dezdeqness.domain.model.GenreEntity

interface GenreLocalDataSource {

    fun getGenres(): List<GenreEntity>

    fun saveGenres(list: List<GenreEntity>)

}
