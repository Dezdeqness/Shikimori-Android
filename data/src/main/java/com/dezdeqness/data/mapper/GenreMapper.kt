package com.dezdeqness.data.mapper

import com.dezdeqness.data.model.GenreRemote
import com.dezdeqness.data.model.db.GenreLocal
import com.dezdeqness.domain.model.GenreEntity
import com.dezdeqness.domain.model.TypeEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GenreMapper @Inject constructor() {

    fun fromResponse(item: GenreRemote) =
        GenreEntity(
            id = item.id,
            name = item.name,
            russian = item.russian,
            type = TypeEntity.fromString(item.type)
        )

    fun toDatabase(item: GenreEntity) =
        GenreLocal(
            genreId = item.id,
            name = item.name,
            russian = item.russian,
            type = item.type.type,
        )

    fun fromDatabase(item: GenreLocal) =
        GenreEntity(
            id = item.id,
            name = item.name,
            russian = item.russian,
            type = TypeEntity.fromString(item.type)
        )

}
