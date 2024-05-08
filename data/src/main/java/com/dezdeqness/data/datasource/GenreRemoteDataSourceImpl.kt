package com.dezdeqness.data.datasource

import com.dezdeqness.data.GenreApiService
import com.dezdeqness.data.core.ApiException
import com.dezdeqness.data.core.BaseDataSource
import com.dezdeqness.data.mapper.GenreMapper
import javax.inject.Inject

class GenreRemoteDataSourceImpl @Inject constructor(
    private val genreMapper: GenreMapper,
    private val genreApiService: GenreApiService,
) : GenreRemoteDataSource, BaseDataSource() {

    override fun getGenres() = tryWithCatch {
        val response = genreApiService.getListAnime().execute()

        val responseBody = response.body()

        if (response.isSuccessful && responseBody != null) {
            val list = responseBody.map { item -> genreMapper.fromResponse(item) }
            Result.success(list)
        } else {
            throw ApiException(response.code(), response.errorBody().toString())
        }

    }

}
