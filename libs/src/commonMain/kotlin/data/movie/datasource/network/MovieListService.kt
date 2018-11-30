package data.movie.datasource.network

import common.datasource.network.NetworkService
import data.movie.entity.MovieEntity

class MovieListService : NetworkService<List<MovieEntity>>() {

    override val path: String
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun parse(json: String): List<MovieEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
