package com.dezdeqness.domain.repository

import com.dezdeqness.domain.model.GenreEntity

interface GenreRepository {

    fun fetchGenres(): Result<List<GenreEntity>>

    fun getGenresLocal(): List<GenreEntity>

}
