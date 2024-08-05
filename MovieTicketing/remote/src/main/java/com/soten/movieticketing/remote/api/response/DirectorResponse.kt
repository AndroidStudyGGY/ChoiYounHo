package com.soten.movieticketing.remote.api.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DirectorResponse(
    @SerialName("peopleNm")
    val peopleNm: String
)