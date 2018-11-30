package domain.repository

import domain.interactor.RequestParams
import domain.model.Movie

interface MovieRepository {

    suspend fun getMovieList(params: RequestParams): List<Movie>

    suspend fun getMovieDetail(id: Int): Movie

}
