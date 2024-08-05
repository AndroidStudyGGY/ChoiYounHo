package com.soten.movieticketing.data.mapper

import com.soten.movieticketing.domain.models.Company
import com.soten.movieticketing.domain.models.Director
import com.soten.movieticketing.domain.models.Movie
import com.soten.movieticketing.domain.models.MovieModels
import com.soten.movieticketing.remote.api.response.DirectorResponse
import com.soten.movieticketing.remote.api.response.MovieListResultResponse
import com.soten.movieticketing.remote.api.response.MovieResponse

fun MovieListResultResponse.toDomain(): MovieModels {
    return MovieModels(
        movieList = movieList.map { it.toDomain() },
        source = source,
        totCnt = totCnt
    )
}

fun MovieResponse.toDomain(): Movie {
    return Movie(
        movieCd = movieCd,
        movieNm = movieNm,
        movieNmEn = movieNmEn,
        prdtYear = prdtYear,
        openDt = openDt,
        typeNm = typeNm,
        prdtStatNm = prdtStatNm,
        nationAlt = nationAlt,
        genreAlt = genreAlt,
        repNationNm = repNationNm,
        repGenreNm = repGenreNm,
        directors = directors.map { it.toDomain() },
        companys = companys.map { it.toDomain() }
    )
}

fun DirectorResponse.toDomain(): Director {
    return Director(
        peopleNm = peopleNm,
    )
}

fun com.soten.movieticketing.remote.api.response.CompanyResponse.toDomain(): Company {
    return Company(
        companyCd = companyCd,
        companyNm = companyNm,
    )
}