package com.soten.movieticketing.remote.source

import com.soten.movieticketing.remote.api.MovieApi
import javax.inject.Inject

class MovieDataSource @Inject constructor(
   private val movieApi: MovieApi
) {

    suspend fun getMovies(page: Int) = movieApi.getMovieList(page = page)
}