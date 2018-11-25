package domain.interactor

import domain.model.Movie
import domain.model.SortType
import domain.repository.MovieRepository

class GetMovieList(
    private val repository: MovieRepository
) : Interactor<GetMovieList.Params, List<Movie>>() {

    override suspend fun build(params: Params?): List<Movie> {
        if (params == null) throw IllegalArgumentException("Params should not be null")
        return repository.getMovieList(params)
    }

    data class Params(
        private val year: Int,
        private val page: Int,
        private val sortType: SortType
    ) : RequestParams

}