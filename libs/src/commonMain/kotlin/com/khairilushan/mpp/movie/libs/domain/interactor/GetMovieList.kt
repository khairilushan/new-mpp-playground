package com.khairilushan.mpp.movie.libs.domain.interactor

import com.khairilushan.mpp.movie.libs.domain.model.Movie
import com.khairilushan.mpp.movie.libs.domain.model.SortType
import com.khairilushan.mpp.movie.libs.domain.repository.MovieRepository
import com.khairilushan.mpp.movie.libs.utils.ServiceLocator

class GetMovieList internal constructor(
    private val repository: MovieRepository
) : Interactor<GetMovieList.Params, List<Movie>>() {

    companion object {
        fun create(): GetMovieList {
            return GetMovieList(ServiceLocator.Movie.repository)
        }
    }

    override suspend fun build(params: Params?): List<Movie> {
        if (params == null) throw IllegalArgumentException("Params should not be null")
        return repository.getMovieList(params.year, params.page, params.sortType.urlQueryValue)
    }

    data class Params(val year: Int, val page: Int, val sortType: SortType)

}
