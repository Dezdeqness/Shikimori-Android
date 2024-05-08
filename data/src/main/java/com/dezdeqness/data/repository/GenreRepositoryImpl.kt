package com.dezdeqness.data.repository

import com.dezdeqness.data.datasource.GenreRemoteDataSource
import com.dezdeqness.data.datasource.db.GenreLocalDataSource
import com.dezdeqness.domain.repository.GenreRepository
import javax.inject.Inject

class GenreRepositoryImpl @Inject constructor(
    private val genreRemoteDataSource: GenreRemoteDataSource,
    private val genreLocalDataSource: GenreLocalDataSource,
): GenreRepository {

    override fun fetchGenres() =
        genreRemoteDataSource
            .getGenres()
            .onSuccess {
                genreLocalDataSource.saveGenres(it)
            }

    override fun getGenresLocal() = genreLocalDataSource.getGenres()
}
