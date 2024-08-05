package com.soten.movieticketing.domain.repository

import androidx.paging.PagingData
import com.soten.movieticketing.domain.models.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    fun getMovies(): Flow<PagingData<Movie>>

    fun getMovieDetail(movieCd: String): Flow<Movie>
}