package com.dezdeqness.data.datasource

import com.dezdeqness.domain.model.GenreEntity

interface GenreRemoteDataSource {
    fun getGenres(): Result<List<GenreEntity>>
}
