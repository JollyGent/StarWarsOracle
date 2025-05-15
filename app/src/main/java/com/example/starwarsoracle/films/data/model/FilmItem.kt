package com.example.starwarsoracle.films.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FilmItem(
    @SerialName("characters")
    val characters: List<String?>? = null,
    @SerialName("created")
    val created: String? = null,
    @SerialName("director")
    val director: String? = null,
    @SerialName("edited")
    val edited: String? = null,
    @SerialName("episode_id")
    val episodeId: Int? = null,
    @SerialName("opening_crawl")
    val openingCrawl: String? = null,
    @SerialName("planets")
    val planets: List<String?>? = null,
    @SerialName("producer")
    val producer: String? = null,
    @SerialName("release_date")
    val releaseDate: String? = null,
    @SerialName("species")
    val species: List<String?>? = null,
    @SerialName("starships")
    val starships: List<String?>? = null,
    @SerialName("title")
    val title: String? = null,
    @SerialName("url")
    val url: String? = null,
    @SerialName("vehicles")
    val vehicles: List<String?>? = null
)