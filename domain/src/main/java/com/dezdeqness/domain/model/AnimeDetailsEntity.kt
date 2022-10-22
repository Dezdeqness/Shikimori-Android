package com.dezdeqness.domain.model

data class AnimeDetailsEntity(
    override val id: Long,
    override val name: String,
    override val russian: String,
    val english: String,
    val japanese: String,
    override val score: Float,
    override val kind: AnimeKind,
    override val url: String,
    val duration: String,
    val rating: String,
    override val status: AnimeStatus,
    override val airedOn: String,
    override val releasedOn: String,
    override val episodes: Int,
    override val episodesAired: Int,
    override val images: Map<String, String>,
    val description: String,
    val studioList: List<StudioEntity>,
    val genreList: List<GenreEntity>,
    val videoList: List<VideoEntity>,
) : AnimeBriefEntity(
    id = id,
    name = name,
    russian = russian,
    images = images,
    url = url,
    kind = kind,
    score = score,
    status = status,
    episodes = episodes,
    episodesAired = episodesAired,
    airedOn = airedOn,
    releasedOn = releasedOn,
)