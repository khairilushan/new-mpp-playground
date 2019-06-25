package com.khairilushan.mpp.movie.libs.domain.interactor

import com.khairilushan.mpp.movie.libs.domain.model.Movie
import com.khairilushan.mpp.movie.libs.domain.repository.MovieRepository
import com.khairilushan.mpp.movie.libs.utils.ServiceLocator

class GetMovieDetail internal constructor(
    private val repository: MovieRepository
) : Interactor<GetMovieDetail.Params, Movie>() {

    companion object {
        fun create(): GetMovieDetail {
            return GetMovieDetail(ServiceLocator.Movie.repository)
        }
    }

    override suspend fun build(params: Params?): Movie {
        if (params == null) throw IllegalArgumentException("Params should not be null")
        return repository.getMovieDetail(params.movieId)
    }

    data class Params(val movieId: Int)
}
