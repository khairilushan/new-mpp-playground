package domain.interactor

import domain.model.Movie
import domain.repository.MovieRepository

class GetMovieDetail(
    private val repository: MovieRepository
) : Interactor<GetMovieDetail.Params, Movie>() {

    override suspend fun build(params: Params?): Movie {
        if (params == null) throw IllegalArgumentException("Params should not be null")
        return repository.getMovieDetail(params.movieId)
    }

    data class Params(val movieId: Int) : RequestParams
}