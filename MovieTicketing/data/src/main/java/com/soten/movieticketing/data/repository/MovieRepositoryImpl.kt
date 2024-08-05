package com.soten.movieticketing.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.soten.movieticketing.data.paging.MoviePagingDataSource
import com.soten.movieticketing.domain.models.Movie
import com.soten.movieticketing.domain.repository.MovieRepository
import com.soten.movieticketing.remote.source.MovieDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieDataSource: MovieDataSource,
) : MovieRepository {
    override fun getMovies(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
            ),
            pagingSourceFactory = { MoviePagingDataSource(movieDataSource) }
        ).flow
    }

    override fun getMovieDetail(movieCd: String): Flow<Movie> {
        TODO("Not yet implemented")
    }
}