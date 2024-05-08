package com.dezdeqness.data.datasource.db

import com.dezdeqness.data.datasource.db.dao.GenreDao
import com.dezdeqness.data.mapper.GenreMapper
import com.dezdeqness.domain.model.GenreEntity
import javax.inject.Inject

class GenreLocalDataSourceImpl @Inject constructor(
    private val genreDao: GenreDao,
    private val genreMapper: GenreMapper,
) : GenreLocalDataSource {

    override fun getGenres() =
        genreDao
            .getGenres()
            .map(genreMapper::fromDatabase)

    override fun saveGenres(list: List<GenreEntity>) {
        val localList = list.map(genreMapper::toDatabase)
        genreDao.saveGenres(localList)
    }
}

