package com.khairilushan.mpp.movie.libs.data.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieListEntity(
    @SerialName("name") val page: Int,
    @SerialName("total_results") val totalResult: Int,
    @SerialName("total_pages") val totalPage: Int,
    @SerialName("results") val results: List<MovieEntity>
)
