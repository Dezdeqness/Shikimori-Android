package com.dezdeqness.domain.model

data class UserRateEntity(
    val id: Long,
    val score: Long,
    val status: String,
    val text: String,
    val episodes: Long,
    val chapters: Long,
    val volumes: Long,
    val textHTML: String,
    val rewatches: Long,
    val createdAt: String,
    val updatedAt: String,
    val anime: AnimeBriefEntity? = null
) {

    companion object {
        private const val NO_ID = -1L
        fun isEmptyUserRate(id: Long) = id == NO_ID

        val EMPTY_USER_RATE = UserRateEntity(
            id = NO_ID,
            score = 0,
            status = "",
            text = "",
            episodes = 0,
            chapters = 0,
            volumes = 0,
            textHTML = "",
            rewatches = 0,
            updatedAt = "",
            createdAt = "",
        )
    }
}
