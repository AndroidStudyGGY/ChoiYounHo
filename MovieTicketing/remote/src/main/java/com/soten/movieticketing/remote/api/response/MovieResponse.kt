package com.soten.movieticketing.remote.api.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieResponse(
    @SerialName("movieListResult")
    val movieListResult: MovieListResult
)