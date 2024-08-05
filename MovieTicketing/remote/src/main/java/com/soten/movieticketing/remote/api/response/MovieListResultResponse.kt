package com.soten.movieticketing.remote.api.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class MovieListResponse(
    @SerialName("movieListResult")
    val movieListResult: MovieListResultResponse
)

@Serializable
data class MovieListResultResponse(
    @SerialName("movieList")
    val movieList: List<MovieResponse>,
    @SerialName("source")
    val source: String,
    @SerialName("totCnt")
    val totCnt: Int
)