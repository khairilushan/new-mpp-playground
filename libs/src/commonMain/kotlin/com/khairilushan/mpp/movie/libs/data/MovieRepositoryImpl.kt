package com.khairilushan.mpp.movie.libs.data

import com.khairilushan.mpp.movie.libs.domain.model.Movie
import com.khairilushan.mpp.movie.libs.domain.repository.MovieRepository

internal class MovieRepositoryImpl(
    private val network: MovieDataSource
) : MovieRepository {

    override suspend fun getMovieList(year: Int, page: Int, sort: String): List<Movie> {
        return network.getMovieList(year, page, sort)
    }

    override suspend fun getMovieDetail(id: Int): Movie {
        return network.getMovieDetail(id)
    }

}
