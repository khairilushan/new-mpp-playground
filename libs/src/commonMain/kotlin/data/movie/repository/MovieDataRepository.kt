package data.movie.repository

import domain.interactor.RequestParams
import domain.model.Movie
import domain.repository.MovieRepository

class MovieDataRepository(
    private val networkDataSource: MovieDataSource
): MovieRepository {

    override suspend fun getMovieList(params: RequestParams): List<Movie>  = networkDataSource.getMovieList(params)

    override suspend fun getMovieDetail(id: Int): Movie = networkDataSource.getMovieDetail(id)

}

interface MovieDataSource: MovieRepository
