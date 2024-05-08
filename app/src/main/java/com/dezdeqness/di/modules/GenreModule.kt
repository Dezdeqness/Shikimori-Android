package com.dezdeqness.di.modules

import com.dezdeqness.data.GenreApiService
import com.dezdeqness.data.database.ShikimoriDatabase
import com.dezdeqness.data.datasource.GenreRemoteDataSource
import com.dezdeqness.data.datasource.GenreRemoteDataSourceImpl
import com.dezdeqness.data.datasource.db.GenreLocalDataSource
import com.dezdeqness.data.datasource.db.GenreLocalDataSourceImpl
import com.dezdeqness.data.repository.GenreRepositoryImpl
import com.dezdeqness.domain.repository.GenreRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
abstract class GenreModule {

    companion object {
        @Provides
        fun provideAccountApiService(retrofit: Retrofit): GenreApiService =
            retrofit.create(GenreApiService::class.java)

        @Provides
        fun provideUserRatesDao(shikimoriDatabase: ShikimoriDatabase) =
            shikimoriDatabase.genreDao()
    }

    @Binds
    abstract fun bindGenreRemoteDataSource(
        genreRemoteDataSource: GenreRemoteDataSourceImpl
    ): GenreRemoteDataSource

    @Binds
    abstract fun bindGenreLocalDataSource(
        genreLocalDataSource: GenreLocalDataSourceImpl
    ): GenreLocalDataSource

    @Binds
    abstract fun bindGenreRepository(
        genreRepository: GenreRepositoryImpl
    ): GenreRepository

}
