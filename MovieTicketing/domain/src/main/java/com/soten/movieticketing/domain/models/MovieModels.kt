package com.soten.movieticketing.domain.models

data class MovieModels(
    val movieList: List<Movie>,
    val source: String,
    val totCnt: Int
)

data class Movie(
    val movieCd: String,
    val movieNm: String,
    val movieNmEn: String,
    val prdtYear: String,
    val openDt: String,
    val typeNm: String,
    val prdtStatNm: String,
    val nationAlt: String,
    val genreAlt: String,
    val repNationNm: String,
    val repGenreNm: String,
    val directors: List<Director>,
    val companys: List<Company>
)

data class Company(
    val companyCd: String,
    val companyNm: String,
)

data class Director(
    val peopleNm: String,
)

