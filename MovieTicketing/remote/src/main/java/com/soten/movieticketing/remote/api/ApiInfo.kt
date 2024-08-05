package com.soten.movieticketing.remote.api

object ApiInfo {
    const val BASE_URL = "http://www.kobis.or.kr/kobisopenapi/"
    const val KEY = "7ec1bb57c28eb56fb8bd2c64aac6bb2e"

    object EndPoints {
        const val SEARCH = "webservice/rest/movie/searchMovieList.json"
        const val DETAIL = "webservice/rest/movie/searchMovieInfo.json"
    }
}