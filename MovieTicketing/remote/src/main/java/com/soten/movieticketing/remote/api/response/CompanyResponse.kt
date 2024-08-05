package com.soten.movieticketing.remote.api.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CompanyResponse(
    @SerialName("companyCd")
    val companyCd: String,
    @SerialName("companyNm")
    val companyNm: String
)