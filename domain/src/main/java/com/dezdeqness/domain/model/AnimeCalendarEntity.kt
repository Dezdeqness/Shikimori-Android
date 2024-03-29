package com.dezdeqness.domain.model

data class AnimeCalendarEntity(
    val duration: Int,
    val nextEpisode: Int,
    val nextEpisodeAtTimestamp: Long,
    val anime: AnimeBriefEntity,
)
