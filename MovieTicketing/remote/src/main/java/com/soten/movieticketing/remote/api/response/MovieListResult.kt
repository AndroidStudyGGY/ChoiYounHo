package com.soten.movieticketing.remote.api.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieListResult(
    @SerialName("movieList")
    val movieList: List<Movie>,
    @SerialName("source")
    val source: String,
    @SerialName("totCnt")
    val totCnt: Int
)