package com.khairilushan.mpp.movie.libs.domain.repository

import com.khairilushan.mpp.movie.libs.domain.model.Movie

internal interface MovieRepository {

    suspend fun getMovieList(year: Int, page: Int, sort: String): List<Movie>

    suspend fun getMovieDetail(id: Int): Movie

}
