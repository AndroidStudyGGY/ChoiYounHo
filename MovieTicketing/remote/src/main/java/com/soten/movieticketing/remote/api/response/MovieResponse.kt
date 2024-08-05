package com.soten.movieticketing.remote.api.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieResponse(
    @SerialName("companys")
    val companys: List<CompanyResponse>,
    @SerialName("directors")
    val directors: List<DirectorResponse>,
    @SerialName("genreAlt")
    val genreAlt: String,
    @SerialName("movieCd")
    val movieCd: String,
    @SerialName("movieNm")
    val movieNm: String,
    @SerialName("movieNmEn")
    val movieNmEn: String,
    @SerialName("nationAlt")
    val nationAlt: String,
    @SerialName("openDt")
    val openDt: String,
    @SerialName("prdtStatNm")
    val prdtStatNm: String,
    @SerialName("prdtYear")
    val prdtYear: String,
    @SerialName("repGenreNm")
    val repGenreNm: String,
    @SerialName("repNationNm")
    val repNationNm: String,
    @SerialName("typeNm")
    val typeNm: String
)