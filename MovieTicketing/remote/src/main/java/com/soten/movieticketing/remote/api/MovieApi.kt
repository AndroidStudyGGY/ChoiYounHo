package com.soten.movieticketing.remote.api

import com.soten.movieticketing.remote.api.ApiInfo.EndPoints
import com.soten.movieticketing.remote.api.response.MovieListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET(EndPoints.SEARCH)
    suspend fun getMovieList(
        @Query("key") key: String = ApiInfo.KEY,
        @Query("curPage") page: Int = DEFAULT_PAGE,
        @Query("itemPerPage") itemPerPage: Int = DEFAULT_ITEM_PER_PAGE
    ): MovieListResponse

    companion object {
        const val DEFAULT_PAGE = 1
        const val DEFAULT_ITEM_PER_PAGE = 30
    }
}