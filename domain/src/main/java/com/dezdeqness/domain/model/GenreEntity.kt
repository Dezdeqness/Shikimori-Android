package com.dezdeqness.domain.model

data class GenreEntity(
    val id: Int,
    val name: String,
    val russian: String,
    val type: TypeEntity,
) {
    val searchId = "${id}-${name}"
}
