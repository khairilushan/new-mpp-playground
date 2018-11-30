package data.movie.datasource

import data.movie.repository.MovieDataSource
import domain.interactor.RequestParams
import domain.model.Movie

class MovieNetworkDataSource: MovieDataSource {

    override suspend fun getMovieList(params: RequestParams): List<Movie> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getMovieDetail(id: Int): Movie {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
