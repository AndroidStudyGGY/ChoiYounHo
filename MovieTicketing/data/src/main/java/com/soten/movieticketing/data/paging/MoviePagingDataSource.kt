package com.soten.movieticketing.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.soten.movieticketing.data.mapper.toDomain
import com.soten.movieticketing.domain.models.Movie
import com.soten.movieticketing.remote.source.MovieDataSource
import javax.inject.Inject

class MoviePagingDataSource @Inject constructor(
    private val movieDataSource: MovieDataSource
): PagingSource<Int, Movie>() {

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? = null

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            val nextPage = params.key ?: 1
            val response = movieDataSource.getMovies(nextPage)
            LoadResult.Page(
                data = response.movieListResult.movieList.map { it.toDomain() },
                prevKey = null,
                nextKey = nextPage + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}